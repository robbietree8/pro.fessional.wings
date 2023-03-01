package pro.fessional.wings.slardar.security.impl;

import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.server.PathContainer;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;
import pro.fessional.wings.slardar.security.WingsAuthHelper;
import pro.fessional.wings.slardar.security.WingsAuthTypeParser;
import pro.fessional.wings.slardar.security.WingsAuthTypeSource;

import java.util.Map;

/**
 * 支持 header，param，AntPath (/login/*.json)
 *
 * @author trydofor
 * @see org.springframework.web.util.pattern.PathPattern
 * @since 2021-02-08
 */
public class DefaultWingsAuthTypeSource implements WingsAuthTypeSource {

    private final String pathPattern;
    private final WingsAuthTypeParser typeParser;
    private final boolean hasTypePath;
    private final boolean hasZonePath;

    /**
     * 如果不支持对应的类型，设置为null，antPath中，支持authType路径参数
     *
     * @param pathPattern 路径参数，参考PathPattern
     * @param typeParser  enums.name
     */
    public DefaultWingsAuthTypeSource(String pathPattern, WingsAuthTypeParser typeParser) {
        this.pathPattern = pathPattern;
        this.typeParser = typeParser;
        this.hasTypePath = pathPattern.contains(WingsAuthHelper.AuthType);
        this.hasZonePath = pathPattern.contains(WingsAuthHelper.AuthZone);
    }

    @Override
    public @NotNull Enum<?> buildAuthType(HttpServletRequest request) {
        String type = null;
        String zone = null;

        if (hasTypePath || hasZonePath) {
            final PathPattern parse = PathPatternParser.defaultInstance.parse(pathPattern);
            final PathPattern.PathMatchInfo info = parse.matchAndExtract(PathContainer.parsePath(request.getRequestURI()));
            if (info != null) {
                final Map<String, String> mp = info.getUriVariables();
                type = mp.get(WingsAuthHelper.AuthType);
                zone = mp.get(WingsAuthHelper.AuthZone);
            }
        }

        if (type == null || type.isEmpty()) {
            type = request.getParameter(WingsAuthHelper.AuthType);
        }

        if (zone == null || zone.isEmpty()) {
            zone = request.getParameter(WingsAuthHelper.AuthZone);
        }

        final Enum<?> enu = typeParser.parse(type);

        WingsAuthHelper.setAuthTypeAttribute(request, enu);
        WingsAuthHelper.setAuthZoneAttribute(request, zone);

        return enu;
    }
}
