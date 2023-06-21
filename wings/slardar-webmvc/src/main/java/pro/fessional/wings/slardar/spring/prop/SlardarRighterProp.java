package pro.fessional.wings.slardar.spring.prop;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import pro.fessional.wings.slardar.webmvc.SimpleResponse;

/**
 * Anti forgery editing, prevent editor privilege upgrade.
 * wings-righter-79.properties
 *
 * @author trydofor
 * @see #Key
 * @since 2021-02-14
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ConfigurationProperties(SlardarRighterProp.Key)
public class SlardarRighterProp extends SimpleResponse {

    public static final String Key = "wings.slardar.righter";

    /**
     * key in header.
     *
     * @see #Key$header
     */
    private String header = "";
    public static final String Key$header = Key + ".header";
}
