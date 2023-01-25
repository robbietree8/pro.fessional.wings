/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.faceless.database.autogen.tables.interfaces;


import javax.annotation.processing.Generated;
import java.io.Serializable;


/**
 * The table <code>wings.sys_standard_i18n</code>.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.16",
        "schema version:2019060102"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface ISysStandardI18n extends Serializable {

    /**
     * Setter for <code>sys_standard_i18n.base</code>.
     */
    public void setBase(String value);

    /**
     * Getter for <code>sys_standard_i18n.base</code>.
     */
    public String getBase();

    /**
     * Setter for <code>sys_standard_i18n.kind</code>.
     */
    public void setKind(String value);

    /**
     * Getter for <code>sys_standard_i18n.kind</code>.
     */
    public String getKind();

    /**
     * Setter for <code>sys_standard_i18n.ukey</code>.
     */
    public void setUkey(String value);

    /**
     * Getter for <code>sys_standard_i18n.ukey</code>.
     */
    public String getUkey();

    /**
     * Setter for <code>sys_standard_i18n.lang</code>.
     */
    public void setLang(String value);

    /**
     * Getter for <code>sys_standard_i18n.lang</code>.
     */
    public String getLang();

    /**
     * Setter for <code>sys_standard_i18n.hint</code>.
     */
    public void setHint(String value);

    /**
     * Getter for <code>sys_standard_i18n.hint</code>.
     */
    public String getHint();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface ISysStandardI18n
     */
    public void from(ISysStandardI18n from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface ISysStandardI18n
     */
    public <E extends ISysStandardI18n> E into(E into);
}
