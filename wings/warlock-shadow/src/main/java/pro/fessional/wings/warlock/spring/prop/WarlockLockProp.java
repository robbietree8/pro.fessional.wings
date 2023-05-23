package pro.fessional.wings.warlock.spring.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * wings-warlock-lock-77.properties
 *
 * @author trydofor
 * @see #Key
 * @since 2021-02-17
 */
@Data
@ConfigurationProperties(WarlockLockProp.Key)
public class WarlockLockProp {

    public static final String Key = "wings.warlock.lock";

    /**
     * whether to use useCpIfSafe in hazelcast GlobalLock.
     *
     * @see #Key$hazelcastCp
     */
    private boolean hazelcastCp = true;
    public static final String Key$hazelcastCp = Key + ".hazelcast-cp";
}
