/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.example.database.autogen.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Row9;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;

import pro.fessional.wings.example.database.autogen.DefaultSchema;
import pro.fessional.wings.example.database.autogen.tables.records.WinAuthRoleRecord;
import pro.fessional.wings.faceless.convention.EmptyValue;
import pro.fessional.wings.faceless.database.jooq.WingsAliasTable;
import pro.fessional.wings.faceless.service.lightid.LightIdAware;


/**
 * The table <code>wings_example.win_auth_role</code>.
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
public class WinAuthRoleTable extends TableImpl<WinAuthRoleRecord> implements WingsAliasTable<WinAuthRoleTable>, LightIdAware {

    private static final long serialVersionUID = -393919269;

    /**
     * The reference instance of <code>win_auth_role</code>
     */
    public static final WinAuthRoleTable WinAuthRole = new WinAuthRoleTable();
    public static final WinAuthRoleTable asS1 = WinAuthRole.as("s1");

    /**
     * The class holding records for this type
     */
    @Override
    public Class<WinAuthRoleRecord> getRecordType() {
        return WinAuthRoleRecord.class;
    }

    /**
     * The column <code>win_auth_role.id</code>.
     */
    public final TableField<WinAuthRoleRecord, Long> Id = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "主键");

    /**
     * The column <code>win_auth_role.create_dt</code>.
     */
    public final TableField<WinAuthRoleRecord, LocalDateTime> CreateDt = createField(DSL.name("create_dt"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP(3)", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "创建日时(系统)");

    /**
     * The column <code>win_auth_role.modify_dt</code>.
     */
    public final TableField<WinAuthRoleRecord, LocalDateTime> ModifyDt = createField(DSL.name("modify_dt"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.inline("1000-01-01 00:00:00.000", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "修改日时(系统)");

    /**
     * The column <code>win_auth_role.delete_dt</code>.
     */
    public final TableField<WinAuthRoleRecord, LocalDateTime> DeleteDt = createField(DSL.name("delete_dt"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.inline("1000-01-01 00:00:00.000", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "标记删除");

    /**
     * The column <code>win_auth_role.commit_id</code>.
     */
    public final TableField<WinAuthRoleRecord, Long> CommitId = createField(DSL.name("commit_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "提交id");

    /**
     * The column <code>win_auth_role.role_type</code>.
     */
    public final TableField<WinAuthRoleRecord, Integer> RoleType = createField(DSL.name("role_type"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "类型/40201##:financial|operation");

    /**
     * The column <code>win_auth_role.role_name</code>.
     */
    public final TableField<WinAuthRoleRecord, String> RoleName = createField(DSL.name("role_name"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "名字");

    /**
     * The column <code>win_auth_role.desc</code>.
     */
    public final TableField<WinAuthRoleRecord, String> Desc = createField(DSL.name("desc"), org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "描述");

    /**
     * The column <code>win_auth_role.auth_set</code>.
     */
    public final TableField<WinAuthRoleRecord, String> AuthSet = createField(DSL.name("auth_set"), org.jooq.impl.SQLDataType.VARCHAR(3000).nullable(false), this, "权限集:authority#401####，逗号分割");

    /**
     * Create a <code>win_auth_role</code> table reference
     */
    public WinAuthRoleTable() {
        this(DSL.name("win_auth_role"), null);
    }

    /**
     * Create an aliased <code>win_auth_role</code> table reference
     */
    public WinAuthRoleTable(String alias) {
        this(DSL.name(alias), WinAuthRole);
    }

    /**
     * Create an aliased <code>win_auth_role</code> table reference
     */
    public WinAuthRoleTable(Name alias) {
        this(alias, WinAuthRole);
    }

    private WinAuthRoleTable(Name alias, Table<WinAuthRoleRecord> aliased) {
        this(alias, aliased, null);
    }

    private WinAuthRoleTable(Name alias, Table<WinAuthRoleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("402/权限组(角色)"));
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<WinAuthRoleRecord> getPrimaryKey() {
        return Internal.createUniqueKey(pro.fessional.wings.example.database.autogen.tables.WinAuthRoleTable.WinAuthRole, "KEY_win_auth_role_PRIMARY", pro.fessional.wings.example.database.autogen.tables.WinAuthRoleTable.WinAuthRole.Id);
    }

    @Override
    public List<UniqueKey<WinAuthRoleRecord>> getKeys() {
        return Arrays.<UniqueKey<WinAuthRoleRecord>>asList(
              Internal.createUniqueKey(pro.fessional.wings.example.database.autogen.tables.WinAuthRoleTable.WinAuthRole, "KEY_win_auth_role_PRIMARY", pro.fessional.wings.example.database.autogen.tables.WinAuthRoleTable.WinAuthRole.Id)
        );
    }

    @Override
    public WinAuthRoleTable as(String alias) {
        return new WinAuthRoleTable(DSL.name(alias), this);
    }

    @Override
    public WinAuthRoleTable as(Name alias) {
        return new WinAuthRoleTable(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public WinAuthRoleTable rename(String name) {
        return new WinAuthRoleTable(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public WinAuthRoleTable rename(Name name) {
        return new WinAuthRoleTable(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<Long, LocalDateTime, LocalDateTime, LocalDateTime, Long, Integer, String, String, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * alias S1
     */
    @Override
    public WinAuthRoleTable getAliasTable() {
        return asS1;
    }

    /**
     * The column <code>delete_dt</code> condition
     */
    public final Condition onlyDiedData = DeleteDt.gt(EmptyValue.DATE_TIME);
    public final Condition onlyLiveData = DeleteDt.eq(EmptyValue.DATE_TIME);
    @Override
    public Condition getOnlyDied() {
        return onlyDiedData;
    }
    @Override
    public Condition getOnlyLive() {
        return onlyLiveData;
    }
}
