/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.warlock.database.autogen;


import org.jooq.Constants;
import org.jooq.impl.CatalogImpl;

import javax.annotation.processing.Generated;


/**
 * The catalog <code></code>.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.18.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class DefaultCatalogWarlock extends CatalogImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>DEFAULT_CATALOG</code>
     */
    public static final DefaultCatalogWarlock DEFAULT_CATALOG = new DefaultCatalogWarlock();

    /**
     * No further instances allowed
     */
    private DefaultCatalogWarlock() {
        super("");
    }

    /**
     * A reference to the 3.18 minor release of the code generator. If this
     * doesn't compile, it's because the runtime library uses an older minor
     * release, namely: 3.18. You can turn off the generation of this reference
     * by specifying /configuration/generator/generate/jooqVersionReference
     */
    private static final String REQUIRE_RUNTIME_JOOQ_VERSION = Constants.VERSION_3_18;
}
