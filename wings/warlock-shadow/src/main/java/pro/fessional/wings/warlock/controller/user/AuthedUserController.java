package pro.fessional.wings.warlock.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.session.MapSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pro.fessional.mirana.data.R;
import pro.fessional.wings.slardar.context.SecurityContextUtil;
import pro.fessional.wings.slardar.security.WingsUserDetails;
import pro.fessional.wings.slardar.session.SessionTokenEncoder;
import pro.fessional.wings.slardar.session.WingsSessionHelper;
import pro.fessional.wings.warlock.spring.prop.WarlockEnabledProp;
import pro.fessional.wings.warlock.spring.prop.WarlockUrlmapProp;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 需要配置权限，通过filter配置或方法级的@PreAuthorize("isAuthenticated()")
 *
 * @author trydofor
 * @since 2021-02-16
 */
// @PreAuthorize("isAuthenticated()")
@RestController
@RequiredArgsConstructor
@Slf4j
@ConditionalOnProperty(name = WarlockEnabledProp.Key$controllerUser, havingValue = "true")
public class AuthedUserController {

    @Setter(onMethod_ = {@Autowired})
    private WingsSessionHelper wingsSessionHelper;
    @Setter(onMethod_ = {@Autowired(required = false)})
    private SessionTokenEncoder sessionTokenEncoder;

    @Schema(description = "登录用户基本信息")
    @Data
    public static class Dto {
        @Schema(description = "昵称", example = "trydofor")
        private String nickname;
        @Schema(description = "用户名", example = "trydofor")
        private String username;
        @Schema(description = "语言，参考java.util.Locale", example = "zh-CN")
        private String locale;
        @Schema(description = "时区，参考java.time.ZoneId", example = "Asia/Shanghai")
        private String zoneid;
        @Schema(description = "秒差，与UTC相差的秒数", example = "28800")
        private int offset;
        @Schema(description = "验证类型，此session的登录类型", example = "EMAIL")
        private String authtype;
        @Schema(description = "验证凭证，此session的登录凭证", example = "fd7a5475-bd3b-4086-96b0-b95d11cf1d3c")
        private String token;
    }

    @Operation(summary = "获得登录用户的基本信息", description = """
            # Usage
            只有登录用户才有信息
            ## Params
            无
            ## Returns
            * @return {200 | Result(Dto)} 登录用户，成功返回用户基本信息；
            * @return {200 | Result(false)} 未登录用户，且无URL权限；
            * @return {401} 若设置了URL访问权限且用户未登录；""")
    @PostMapping(value = "${" + WarlockUrlmapProp.Key$userAuthedUser + "}")
    public R<Dto> authedUser(HttpServletRequest request) {
        final WingsUserDetails wd = SecurityContextUtil.getUserDetails(false);
        if (wd == null) return R.ng();

        Dto dto = new Dto();
        fillDetail(wd, dto);
        final HttpSession session = request.getSession(false);
        if (session != null) {
            String sid = session.getId();
            if (sessionTokenEncoder != null) {
                sid = sessionTokenEncoder.encode(sid, request);
            }
            dto.setToken(sid);
        }
        return R.okData(dto);
    }

    private void fillDetail(WingsUserDetails wd, Dto dto) {
        final Enum<?> at = wd.getAuthType();
        if (at != null) {
            dto.setAuthtype(at.name());
        }
        dto.setNickname(wd.getNickname());
        dto.setUsername(wd.getUsername());
        dto.setLocale(wd.getLocale().toLanguageTag());
        final ZoneId zid = wd.getZoneId();
        dto.setZoneid(zid.getId());
        dto.setOffset(ZonedDateTime.now(zid).getOffset().getTotalSeconds());
    }


    @Data
    @Schema(description = "精查登录用户角色权限")
    public static class Ins {
        @Schema(description = "别名项，本名为key，别名为value", example = "{\"ROLE_SYSTEM\":\"OLD_SYSTEM\"}")
        private Map<String, String> alias;
        @Schema(description = "权限项", example = "[\"ROLE_ADMIN\",\"ROLE_SYSTEM\"]")
        private Set<String> perms;
        @Schema(description = "检查项，若检查项未全满足，则invalidate session", example = "[\"ROLE_ADMIN\"]")
        private Set<String> check;
    }

    @Operation(summary = "检查登录用户的权限，不区分大小写比较，返回存在的权限；", description = """
            # Usage
            alias优先于perms检测，check失败时会自动登出logout。
            ## Params
            * @param ins.alias - 以本名为key，别名为value，返回别名，以兼容历史遗留
            * @param ins.perms - 权限或角色的本名
            * @param ins.check - 需要检查的权限或角色的本名
            ## Returns
            * @return {200 | Result(string[])} 登录用户，成功返回用户基本信息；
            * @return {200 | Result(false)} 未登录用户，且无URL权限；
            * @return {200 | Result(false,string[])} check失败，返回失败的权限且invalidate session；
            * @return {401} 若设置了URL访问权限且用户未登录；""")
    @PostMapping(value = "${" + WarlockUrlmapProp.Key$userAuthedPerm + "}")
    public R<Set<String>> authedPerm(HttpServletRequest request, @RequestBody Ins ins) {
        final WingsUserDetails wd = SecurityContextUtil.getUserDetails(false);
        if (wd == null) return R.ng();

        final Set<String> ck = ins.getCheck();
        final Set<String> pm = wd.getAuthorities().stream()
                                 .map(it -> it.getAuthority().toLowerCase())
                                 .collect(Collectors.toSet());

        if (ck != null && !ck.isEmpty()) {
            final Set<String> lt = new HashSet<>();
            for (String s : ck) {
                if (!pm.contains(s.toLowerCase())) {
                    lt.add(s);
                }
            }
            if (!lt.isEmpty()) {
                request.getSession().invalidate();
                return R.ngData(lt);
            }
        }

        Set<String> perms = ins.getPerms();
        if (perms == null) perms = Collections.emptySet();

        Map<String, String> alias = ins.getAlias();
        if (alias == null) alias = Collections.emptyMap();

        if (perms.isEmpty() && alias.isEmpty()) {
            return R.ok();
        }

        // alias 优先于perms
        Map<String, String> ci = new HashMap<>();
        for (String p : perms) {
            ci.put(p.toLowerCase(), p);
        }
        for (Map.Entry<String, String> e : alias.entrySet()) {
            ci.put(e.getKey().toLowerCase(), e.getValue());
        }

        Set<String> res = new HashSet<>();
        for (String p : pm) {
            final String a = ci.get(p);
            if (a != null) {
                res.add(a);
            }
        }

        return R.okData(res);
    }

    @Schema(description = "登录用户会话信息")
    @Data @EqualsAndHashCode(callSuper = true)
    public static class Ses extends Dto {
        @Schema(description = "是否过期", example = "true")
        private boolean expired;
        @Schema(description = "最新访问时间", example = "true")
        private ZonedDateTime lastAccess;
    }

    @Operation(summary = "获得登录用户的所有会话", description = """
            # Usage
            只有登录用户才有信息
            ## Params
            无
            ## Returns
            * @return {200 | Result(Dto)} 登录用户，成功返回用户会话信息；
            * @return {200 | Result(false)} 未登录用户，且无URL权限；
            * @return {401} 若设置了URL访问权限且用户未登录；""")
    @PostMapping(value = "${" + WarlockUrlmapProp.Key$userListSession + "}")
    public R<List<Ses>> listSession() {
        final WingsUserDetails details = SecurityContextUtil.getUserDetails(false);
        if (details == null) return R.ng();

        final List<MapSession> sessions = wingsSessionHelper.findByUserId(details.getUserId());
        final List<Ses> sess = sessions.stream().map(it -> {
            Ses ses = new Ses();
            ses.setToken(it.getId());
            ses.setExpired(it.isExpired());
            ses.setLastAccess(it.getLastAccessedTime().atZone(details.getZoneId()));

            final SecurityContext ctx = wingsSessionHelper.getSecurityContext(it);
            final WingsUserDetails dtl = SecurityContextUtil.getUserDetails(ctx);
            if (dtl != null) {
                fillDetail(dtl, ses);
            }

            return ses;
        }).collect(Collectors.toList());

        return R.okData(sess);
    }

    @Data
    public static class Sid {
        private String sid;
    }

    @Operation(summary = "踢掉一个登录用户的会话", description = """
            # Usage
            只有登录用户才有信息
            ## Params
            * @param sid - 要踢掉的会话Id/token
            ## Returns
            * @return {200 | Result} 登录用户，成功返回用户会话信息；
            * @return {200 | Result(false)} 未登录用户，且无URL权限；
            * @return {401} 若设置了URL访问权限且用户未登录；""")
    @PostMapping(value = "${" + WarlockUrlmapProp.Key$userDropSession + "}")
    public R<Boolean> dropSession(@RequestBody Sid sid) {
        final boolean b = wingsSessionHelper.dropSession(sid.sid);
        return R.okData(b);
    }
}
