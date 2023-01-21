/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.warlock.database.autogen.tables;


import org.jetbrains.annotations.NotNull;
import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Row5;
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
import pro.fessional.wings.faceless.database.jooq.converter.JooqConsEnumConverter;
import pro.fessional.wings.warlock.database.autogen.DefaultSchemaWarlockBond;
import pro.fessional.wings.warlock.database.autogen.tables.records.WinUserGrantRecord;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


/**
 * The table <code>wings_warlock.win_user_grant</code>.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.16",
        "schema version:2020102501"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class WinUserGrantTable extends TableImpl<WinUserGrantRecord> implements WingsJournalTable<WinUserGrantTable> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>win_user_grant</code>
     */
    public static final WinUserGrantTable WinUserGrant = new WinUserGrantTable();
    public static final WinUserGrantTable asR2 = WinUserGrant.as(pro.fessional.wings.faceless.database.jooq.WingsJooqEnv.uniqueAlias());

    /**
     * The class holding records for this type
     */
    @Override
    public Class<WinUserGrantRecord> getRecordType() {
        return WinUserGrantRecord.class;
    }

    /**
     * The column <code>win_user_grant.refer_user</code>.
     */
    public final TableField<WinUserGrantRecord, Long> ReferUser = createField(DSL.name("refer_user"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>win_user_grant.grant_type</code>.
     */
    public final TableField<WinUserGrantRecord, pro.fessional.wings.warlock.enums.autogen.GrantType> GrantType = createField(DSL.name("grant_type"), SQLDataType.INTEGER.nullable(false), this, "", new JooqConsEnumConverter(pro.fessional.wings.warlock.enums.autogen.GrantType.class));

    /**
     * The column <code>win_user_grant.grant_entry</code>.
     */
    public final TableField<WinUserGrantRecord, Long> GrantEntry = createField(DSL.name("grant_entry"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>win_user_grant.create_dt</code>.
     */
    public final TableField<WinUserGrantRecord, LocalDateTime> CreateDt = createField(DSL.name("create_dt"), SQLDataType.LOCALDATETIME(3).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP(3)", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>win_user_grant.commit_id</code>.
     */
    public final TableField<WinUserGrantRecord, Long> CommitId = createField(DSL.name("commit_id"), SQLDataType.BIGINT.nullable(false), this, "");

    private WinUserGrantTable(Name alias, Table<WinUserGrantRecord> aliased) {
        this(alias, aliased, null);
    }

    private WinUserGrantTable(Name alias, Table<WinUserGrantRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>win_user_grant</code> table reference
     */
    public WinUserGrantTable(String alias) {
        this(DSL.name(alias), WinUserGrant);
    }

    /**
     * Create an aliased <code>win_user_grant</code> table reference
     */
    public WinUserGrantTable(Name alias) {
        this(alias, WinUserGrant);
    }

    /**
     * Create a <code>win_user_grant</code> table reference
     */
    public WinUserGrantTable() {
        this(DSL.name("win_user_grant"), null);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchemaWarlockBond.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<WinUserGrantRecord> getPrimaryKey() {
        return Internal.createUniqueKey(WinUserGrantTable.WinUserGrant, DSL.name("KEY_win_user_grant_PRIMARY"), new TableField[] { WinUserGrantTable.WinUserGrant.ReferUser, WinUserGrantTable.WinUserGrant.GrantType, WinUserGrantTable.WinUserGrant.GrantEntry }, true);
    }

    @Override
    public List<UniqueKey<WinUserGrantRecord>> getKeys() {
        return Arrays.<UniqueKey<WinUserGrantRecord>>asList(
              Internal.createUniqueKey(WinUserGrantTable.WinUserGrant, DSL.name("KEY_win_user_grant_PRIMARY"), new TableField[] { WinUserGrantTable.WinUserGrant.ReferUser, WinUserGrantTable.WinUserGrant.GrantType, WinUserGrantTable.WinUserGrant.GrantEntry }, true)
        );
    }

    @Override
    public WinUserGrantTable as(String alias) {
        return new WinUserGrantTable(DSL.name(alias), this);
    }

    @Override
    public WinUserGrantTable as(Name alias) {
        return new WinUserGrantTable(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public WinUserGrantTable rename(String name) {
        return new WinUserGrantTable(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public WinUserGrantTable rename(Name name) {
        return new WinUserGrantTable(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, pro.fessional.wings.warlock.enums.autogen.GrantType, Long, LocalDateTime, Long> fieldsRow() {
        return (Row5) super.fieldsRow();
    }


    /**
     * alias asR2
     */
    @Override
    @NotNull
    public WinUserGrantTable getAliasTable() {
        return asR2;
    }
}
