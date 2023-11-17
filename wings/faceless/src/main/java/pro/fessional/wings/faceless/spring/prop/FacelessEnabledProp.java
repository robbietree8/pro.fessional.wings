package pro.fessional.wings.faceless.spring.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * spring-wings-enabled-79.properties
 *
 * @author trydofor
 * @see #Key
 * @since 2021-02-13
 */
@Data
@ConfigurationProperties(FacelessEnabledProp.Key)
public class FacelessEnabledProp {

    public static final String Key = "spring.wings.faceless.enabled";

    /**
     * Whether to start auto config
     *
     * @see #Key$autoconf
     */
    private boolean autoconf = true;
    public static final String Key$autoconf = Key + ".autoconf";

    /**
     * Whether to inject lingthid
     *
     * @see #Key$lightid
     */
    private boolean lightid = true;
    public static final String Key$lightid = Key + ".lightid";

    /**
     * Whether to inject journal
     *
     * @see #Key$journal
     */
    private boolean journal = true;
    public static final String Key$journal = Key + ".journal";

    /**
     * Whether to inject StandardI18nService
     *
     * @see #Key$enumi18n
     */
    private boolean enumi18n = true;
    public static final String Key$enumi18n = Key + ".enumi18n";
}
