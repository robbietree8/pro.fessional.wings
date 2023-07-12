package pro.fessional.wings.warlock.security.listener;

import com.alibaba.fastjson2.JSON;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import pro.fessional.wings.slardar.context.TerminalContext;
import pro.fessional.wings.slardar.fastjson.FastJsonHelper;
import pro.fessional.wings.slardar.security.WingsAuthDetails;
import pro.fessional.wings.slardar.security.WingsAuthHelper;
import pro.fessional.wings.slardar.security.WingsUserDetails;
import pro.fessional.wings.warlock.service.auth.WarlockAuthnService;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static pro.fessional.wings.slardar.context.TerminalAttribute.TerminalAddr;
import static pro.fessional.wings.slardar.context.TerminalAttribute.TerminalAgent;

/**
 * @author trydofor
 * @since 2021-02-24
 */
@Slf4j
public class WarlockSuccessLoginListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Setter(onMethod_ = {@Autowired})
    protected WarlockAuthnService warlockAuthnService;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        final Object source = event.getSource();
        if (!(source instanceof final Authentication authn)) return;

        final Object principal = authn.getPrincipal();
        if (!(principal instanceof final WingsUserDetails ud)) {
            log.debug("skip non-WingsUserDetails, type={}", source.getClass().getName());
            return;
        }

        Enum<?> authType = ud.getAuthType();
        long userId = ud.getUserId();
        if (authType == null) {
            log.warn("authType should NOT null, userId={}", userId);
            return;
        }
        final Map<String, Object> dtlMap = new HashMap<>();
        dtlMap.put("authType", authType.name());
        dtlMap.put("locale", ud.getLocale());
        dtlMap.put("zoneid", ud.getZoneId());
        dtlMap.put("nickname", ud.getNickname());
        dtlMap.put("username", ud.getUsername());

        final Object dtl = authn.getDetails();
        if (dtl instanceof WingsAuthDetails authDetails) {
            final Map<String, String> meta = authDetails.getMetaData();
            dtlMap.putAll(meta);
            TerminalContext.Builder builder = new TerminalContext.Builder()
                    .locale(ud.getLocale())
                    .timeZone(ud.getZoneId())
                    .terminal(TerminalAddr, meta.get(WingsAuthHelper.AuthAddr))
                    .terminal(TerminalAgent, meta.get(WingsAuthHelper.AuthAgent))
                    .user(userId)
                    .authType(authType)
                    .username(ud.getUsername())
                    .authPerm(ud.getAuthorities().stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toSet()));
            TerminalContext.login(builder.build());
        }

        warlockAuthnService.onSuccess(authType, userId, JSON.toJSONString(dtlMap, FastJsonHelper.DefaultWriter()));
    }
}
