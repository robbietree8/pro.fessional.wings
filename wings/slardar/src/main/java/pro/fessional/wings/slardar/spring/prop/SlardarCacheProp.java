package pro.fessional.wings.slardar.spring.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import pro.fessional.wings.slardar.cache.WingsCache;

import java.util.HashMap;
import java.util.Map;

import static pro.fessional.wings.slardar.cache.WingsCache.Joiner;

/**
 * @author trydofor
 * @see #Key
 * @since 2021-02-11
 */
@Data
@ConfigurationProperties(SlardarCacheProp.Key)
public class SlardarCacheProp {

    public static final String Key = "wings.slardar.cache";

    /**
     * 哪个CacheManager为primary: Memory | Server
     *
     * @see #Key$primary
     */
    private String primary = WingsCache.Manager.Memory;
    public static final String Key$primary = Key + ".primary";

    /**
     * 是否对cache name的进行Resolve扩展，即追加所在类
     *
     * @see #Key$expand
     */
    private boolean expand = true;
    public static final String Key$expand = Key + ".expand";

    /**
     * 原则上不缓存null，但可对null统一处理。正数:缓存大小；0:不缓存null；负数:不统一处理
     *
     * @see #Key$nullSize
     */
    private int nullSize = 1000;
    public static final String Key$nullSize = Key + ".null-size";

    /**
     * @see #Key$nullLive
     */
    private int nullLive = 300;
    public static final String Key$nullLive = Key + ".null-live";

    /**
     * level之外的默认配置
     *
     * @see #Key$common
     */
    private Conf common;
    public static final String Key$common = Key + ".common";

    /**
     * 不同的缓存级别
     *
     * @see #Key$level
     */
    private Map<String, Conf> level = new HashMap<>();
    public static final String Key$level = Key + ".level";

    @Data
    public static class Conf {
        /**
         * expireAfterWrite(Time To Live) seconds
         */
        private int maxLive = 3600;
        /**
         * expireAfterAccess(Time To Idle) seconds
         */
        private int maxIdle = 0;
        /**
         * cache size
         */
        private int maxSize = 0;
    }

    // /////////////////

    public static String wildcard(String level) {
        return WingsCache.Level.join(level, "*");
    }

    public static boolean inLevel(String name, String level) {
        if (name == null || level == null) return false;
        final int len = level.length();
        return name.regionMatches(true, 0, level, 0, len)
               && name.regionMatches(true, len, Joiner, 0, Joiner.length());
    }
}
