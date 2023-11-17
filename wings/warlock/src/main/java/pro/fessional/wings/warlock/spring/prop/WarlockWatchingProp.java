package pro.fessional.wings.warlock.spring.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <pre>
 * wings-warlock-watching-77.properties
 *
 * code tracking , default `-1` means disable; `0` means fully enable.
 *
 * - Controller layer is implemented by Interceptor
 * - Service dependency annotation @Watching
 * - Jooq layer, depends on listener
 * </pre>
 *
 * @author trydofor
 * @see #Key
 * @since 2021-10-09
 */
@Data
@ConfigurationProperties(WarlockWatchingProp.Key)
public class WarlockWatchingProp {

    public static final String Key = "wings.warlock.watching";

    /**
     * threshold millis for jooq execution.
     *
     * @see #Key$jooqThreshold
     */
    private long jooqThreshold = -1;
    public static final String Key$jooqThreshold = Key + ".jooq-threshold";

    /**
     * threshold millis for Watching annotation.
     *
     * @see #Key$serviceThreshold
     */
    private long serviceThreshold = -1;
    public static final String Key$serviceThreshold = Key + ".service-threshold";

    /**
     * threshold millis for Controller.
     *
     * @see #Key$controllerThreshold
     */
    private long controllerThreshold = -1;
    public static final String Key$controllerThreshold = Key + ".controller-threshold";
}
