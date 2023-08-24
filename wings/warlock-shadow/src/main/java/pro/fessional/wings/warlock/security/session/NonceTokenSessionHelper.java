package pro.fessional.wings.warlock.security.session;


import org.cache2k.Cache;
import org.cache2k.Cache2kBuilder;
import org.jetbrains.annotations.Nullable;
import pro.fessional.mirana.data.Null;

import java.util.concurrent.TimeUnit;


/**
 * <pre>
 * Provides a one-time token that valid for 5 minutes to authn.
 * (1) initNonce: Init one-time token
 * (2) bindNonceSid: after successful login, bind token and sessionId by uid.
 * </pre>
 *
 * @author trydofor
 * @since 2021-07-01
 */
public class NonceTokenSessionHelper {

    private static final Cache<String, Sf> cache = Cache2kBuilder
            .of(String.class, Sf.class)
            .entryCapacity(100_000)
            .expireAfterWrite(300, TimeUnit.SECONDS)
            .build();

    private static class Sf {
        private String ip = null;
        private String sid = null;
    }

    /**
     * Init one-time token
     */
    public static void initNonce(String token, String ip) {
        if (token == null) return;
        final Sf s = new Sf();
        s.ip = ip;
        cache.put(token, s);
    }

    /**
     * bind token to sessionId
     */
    public static void bindNonceSid(String token, String sid) {
        final Sf s = cache.get(token);
        if (s != null) {
            s.sid = sid;
        }
    }

    /**
     * invalid the token
     */
    public static void invalidNonce(String token) {
        cache.remove(token);
    }

    /**
     * <pre>
     * null - authn not exist
     * empty - authn in action
     * sid - authn success, (auto remove and return only once)
     * </pre>
     *
     * @param token one-time token
     * @return null|empty|sid
     */
    @Nullable
    public static String authNonce(String token, String ip) {
        if (token == null || token.isEmpty()) return null;

        final Sf s = cache.get(token);
        if (s == null) return null;
        if (s.sid == null) return Null.Str;

        invalidNonce(token);
        return s.ip.equals(ip) ? s.sid : null;
    }
}
