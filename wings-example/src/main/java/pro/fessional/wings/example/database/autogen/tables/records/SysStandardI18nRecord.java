/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.example.database.autogen.tables.records;


import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;

import pro.fessional.wings.example.database.autogen.tables.SysStandardI18nTable;
import pro.fessional.wings.example.database.autogen.tables.interfaces.ISysStandardI18n;


/**
 * The table <code>wings_example.sys_standard_i18n</code>.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4",
        "schema version:2019070403"
    },
    date = "2020-08-13T07:33:30.191Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(name = "sys_standard_i18n", uniqueConstraints = {
    @UniqueConstraint(name = "KEY_sys_standard_i18n_PRIMARY", columnNames = {"base", "kind", "ukey", "lang"})
})
public class SysStandardI18nRecord extends UpdatableRecordImpl<SysStandardI18nRecord> implements Record5<String, String, String, String, String>, ISysStandardI18n {

    private static final long serialVersionUID = -764494187;

    /**
     * Setter for <code>sys_standard_i18n.base</code>.
     */
    @Override
    public void setBase(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>sys_standard_i18n.base</code>.
     */
    @Column(name = "base", nullable = false, length = 100)
    @NotNull
    @Size(max = 100)
    @Override
    public String getBase() {
        return (String) get(0);
    }

    /**
     * Setter for <code>sys_standard_i18n.kind</code>.
     */
    @Override
    public void setKind(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>sys_standard_i18n.kind</code>.
     */
    @Column(name = "kind", nullable = false, length = 100)
    @NotNull
    @Size(max = 100)
    @Override
    public String getKind() {
        return (String) get(1);
    }

    /**
     * Setter for <code>sys_standard_i18n.ukey</code>.
     */
    @Override
    public void setUkey(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>sys_standard_i18n.ukey</code>.
     */
    @Column(name = "ukey", nullable = false, length = 200)
    @NotNull
    @Size(max = 200)
    @Override
    public String getUkey() {
        return (String) get(2);
    }

    /**
     * Setter for <code>sys_standard_i18n.lang</code>.
     */
    @Override
    public void setLang(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>sys_standard_i18n.lang</code>.
     */
    @Column(name = "lang", nullable = false, length = 5)
    @NotNull
    @Size(max = 5)
    @Override
    public String getLang() {
        return (String) get(3);
    }

    /**
     * Setter for <code>sys_standard_i18n.text</code>.
     */
    @Override
    public void setText(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>sys_standard_i18n.text</code>.
     */
    @Column(name = "text", nullable = false, length = 3000)
    @NotNull
    @Size(max = 3000)
    @Override
    public String getText() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record4<String, String, String, String> key() {
        return (Record4) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<String, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<String, String, String, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return SysStandardI18nTable.SysStandardI18n.Base;
    }

    @Override
    public Field<String> field2() {
        return SysStandardI18nTable.SysStandardI18n.Kind;
    }

    @Override
    public Field<String> field3() {
        return SysStandardI18nTable.SysStandardI18n.Ukey;
    }

    @Override
    public Field<String> field4() {
        return SysStandardI18nTable.SysStandardI18n.Lang;
    }

    @Override
    public Field<String> field5() {
        return SysStandardI18nTable.SysStandardI18n.Text;
    }

    @Override
    public String component1() {
        return getBase();
    }

    @Override
    public String component2() {
        return getKind();
    }

    @Override
    public String component3() {
        return getUkey();
    }

    @Override
    public String component4() {
        return getLang();
    }

    @Override
    public String component5() {
        return getText();
    }

    @Override
    public String value1() {
        return getBase();
    }

    @Override
    public String value2() {
        return getKind();
    }

    @Override
    public String value3() {
        return getUkey();
    }

    @Override
    public String value4() {
        return getLang();
    }

    @Override
    public String value5() {
        return getText();
    }

    @Override
    public SysStandardI18nRecord value1(String value) {
        setBase(value);
        return this;
    }

    @Override
    public SysStandardI18nRecord value2(String value) {
        setKind(value);
        return this;
    }

    @Override
    public SysStandardI18nRecord value3(String value) {
        setUkey(value);
        return this;
    }

    @Override
    public SysStandardI18nRecord value4(String value) {
        setLang(value);
        return this;
    }

    @Override
    public SysStandardI18nRecord value5(String value) {
        setText(value);
        return this;
    }

    @Override
    public SysStandardI18nRecord values(String value1, String value2, String value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ISysStandardI18n from) {
        setBase(from.getBase());
        setKind(from.getKind());
        setUkey(from.getUkey());
        setLang(from.getLang());
        setText(from.getText());
    }

    @Override
    public <E extends ISysStandardI18n> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SysStandardI18nRecord
     */
    public SysStandardI18nRecord() {
        super(SysStandardI18nTable.SysStandardI18n);
    }

    /**
     * Create a detached, initialised SysStandardI18nRecord
     */
    public SysStandardI18nRecord(String base, String kind, String ukey, String lang, String text) {
        super(SysStandardI18nTable.SysStandardI18n);

        set(0, base);
        set(1, kind);
        set(2, ukey);
        set(3, lang);
        set(4, text);
    }
}
