/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.warlock.database.autogen.tables;


import org.jetbrains.annotations.NotNull;
import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import pro.fessional.wings.faceless.database.jooq.WingsJournalTable;
import pro.fessional.wings.faceless.service.lightid.LightIdAware;
import pro.fessional.wings.warlock.database.autogen.DefaultSchema;
import pro.fessional.wings.warlock.database.autogen.tables.records.WinUserLoginRecord;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


/**
 * The table <code>wings_warlock.win_user_login</code>.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.15",
        "schema version:2021102301"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class WinUserLoginTable extends TableImpl<WinUserLoginRecord> implements WingsJournalTable<WinUserLoginTable>, LightIdAware {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>win_user_login</code>
     */
    public static final WinUserLoginTable WinUserLogin = new WinUserLoginTable();
    public static final WinUserLoginTable asA2 = WinUserLogin.as(pro.fessional.wings.faceless.database.jooq.WingsJooqEnv.uniqueAlias());

    /**
     * The class holding records for this type
     */
    @Override
    public Class<WinUserLoginRecord> getRecordType() {
        return WinUserLoginRecord.class;
    }

    /**
     * The column <code>win_user_login.id</code>.
     */
    public final TableField<WinUserLoginRecord, Long> Id = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>win_user_login.user_id</code>.
     */
    public final TableField<WinUserLoginRecord, Long> UserId = createField(DSL.name("user_id"), SQLDataType.BIGINT.nullable(false).defaultValue(DSL.inline("0", SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>win_user_login.auth_type</code>.
     */
    public final TableField<WinUserLoginRecord, String> AuthType = createField(DSL.name("auth_type"), SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>win_user_login.login_ip</code>.
     */
    public final TableField<WinUserLoginRecord, String> LoginIp = createField(DSL.name("login_ip"), SQLDataType.VARCHAR(50).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>win_user_login.login_dt</code>.
     */
    public final TableField<WinUserLoginRecord, LocalDateTime> LoginDt = createField(DSL.name("login_dt"), SQLDataType.LOCALDATETIME(3).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP(3)", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>win_user_login.terminal</code>.
     */
    public final TableField<WinUserLoginRecord, String> Terminal = createField(DSL.name("terminal"), SQLDataType.VARCHAR(1000).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>win_user_login.details</code>.
     */
    public final TableField<WinUserLoginRecord, String> Details = createField(DSL.name("details"), SQLDataType.VARCHAR(9000).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>win_user_login.failed</code>.
     */
    public final TableField<WinUserLoginRecord, Boolean> Failed = createField(DSL.name("failed"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.inline("0", SQLDataType.BOOLEAN)), this, "");

    private WinUserLoginTable(Name alias, Table<WinUserLoginRecord> aliased) {
        this(alias, aliased, null);
    }

    private WinUserLoginTable(Name alias, Table<WinUserLoginRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>win_user_login</code> table reference
     */
    public WinUserLoginTable(String alias) {
        this(DSL.name(alias), WinUserLogin);
    }

    /**
     * Create an aliased <code>win_user_login</code> table reference
     */
    public WinUserLoginTable(Name alias) {
        this(alias, WinUserLogin);
    }

    /**
     * Create a <code>win_user_login</code> table reference
     */
    public WinUserLoginTable() {
        this(DSL.name("win_user_login"), null);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<WinUserLoginRecord> getPrimaryKey() {
        return Internal.createUniqueKey(WinUserLoginTable.WinUserLogin, DSL.name("KEY_win_user_login_PRIMARY"), new TableField[] { WinUserLoginTable.WinUserLogin.Id }, true);
    }

    @Override
    public List<UniqueKey<WinUserLoginRecord>> getKeys() {
        return Arrays.<UniqueKey<WinUserLoginRecord>>asList(
              Internal.createUniqueKey(WinUserLoginTable.WinUserLogin, DSL.name("KEY_win_user_login_PRIMARY"), new TableField[] { WinUserLoginTable.WinUserLogin.Id }, true)
        );
    }

    @Override
    public WinUserLoginTable as(String alias) {
        return new WinUserLoginTable(DSL.name(alias), this);
    }

    @Override
    public WinUserLoginTable as(Name alias) {
        return new WinUserLoginTable(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public WinUserLoginTable rename(String name) {
        return new WinUserLoginTable(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public WinUserLoginTable rename(Name name) {
        return new WinUserLoginTable(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, Long, String, String, LocalDateTime, String, String, Boolean> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * LightIdAware seqName
     */
    @Override
    @NotNull
    public String getSeqName() {
        return "win_user_login";
    }


    /**
     * alias asA2
     */
    @Override
    @NotNull
    public WinUserLoginTable getAliasTable() {
        return asA2;
    }
}
