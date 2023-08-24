package pro.fessional.wings.slardar.cache;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;

/**
 * @author trydofor
 * @since 2020-07-30
 */
public interface WingsCache {

    /**
     * <a href="https://github.com/cache2k/cache2k/issues/201">valid chars</a>
     */
    String Joiner = "~";

    /**
     * suffix can be expanded to its implement qualified name
     */
    String Extend = "!";

    /**
     * use wildcard like `program~*` to match cache name prefix.
     */
    String Wildcard = "*";

    class Manager {
        /**
         * cache in current jvm, default cache2k
         */
        public static final String Memory = "MemoryCacheManager";
        /**
         * cache in standalone server, default hazelcast. (or redis)
         */
        public static final String Server = "ServerCacheManager";
    }

    class Resolver {

        public static final String Suffix = "Resolver";

        /**
         * cache in current jvm, default cache2k
         */
        public static final String Memory = Manager.Memory + Suffix;
        /**
         * cache in standalone server, default hazelcast. (or redis)
         */
        public static final String Server = Manager.Server + Suffix;
    }

    class Level {
        /**
         * Program level, during program or service operation
         */
        public static final String Forever = "program" + Joiner;
        /**
         * General, 1 day
         */
        public static final String General = "general" + Joiner;
        /**
         * Service, 1 hour
         */
        public static final String Service = "service" + Joiner;
        /**
         * Session, 10 minutes
         */
        public static final String Session = "session" + Joiner;

        public static String join(String... part) {
            return String.join(Joiner, part);
        }

        public static String forever(String... part) {
            return Forever + String.join(Joiner, part);
        }

        public static String general(String... part) {
            return General + String.join(Joiner, part);
        }

        public static String service(String... part) {
            return Service + String.join(Joiner, part);
        }

        public static String session(String... part) {
            return Session + String.join(Joiner, part);
        }
    }

    interface State {
        /**
         * get name and size of cache
         *
         * @return name-size
         */
        @NotNull
        Map<String, Integer> statsCacheSize();

        /**
         * get keys in cache
         *
         * @param name cache name
         * @return keys
         */
        @NotNull
        Set<Object> statsCacheKeys(String name);
    }
}
