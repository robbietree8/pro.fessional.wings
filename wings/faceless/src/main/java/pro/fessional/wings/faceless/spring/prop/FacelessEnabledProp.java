package pro.fessional.wings.faceless.spring.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import pro.fessional.wings.silencer.spring.boot.WingsEnabledContext;

/**
 * toggling the Silencer feature, wings-enabled-79.properties
 *
 * @author trydofor
 * @see #Key
 * @since 2021-02-13
 */
@Data
@ConfigurationProperties(FacelessEnabledProp.Key)
public class FacelessEnabledProp {

    public static final String Key = WingsEnabledContext.PrefixEnabled + ".faceless";

    /**
     * Whether to use the simple FlakeIdService  generated by lightId
     *
     * @see #Key$simpleFlakeid
     */
    private boolean simpleFlakeid = true;
    public static final String Key$simpleFlakeid = Key + ".simple-flakeid";

    /**
     * Whether to use the simple JournalService without terminal info
     *
     * @see #Key$simpleJournal
     */
    private boolean simpleJournal = true;
    public static final String Key$simpleJournal = Key + ".simple-journal";

    /**
     * whether to enable flywave auto config
     *
     * @see #Key$flywave
     */
    private boolean flywave = false;
    public static final String Key$flywave = Key + ".flywave";
}
