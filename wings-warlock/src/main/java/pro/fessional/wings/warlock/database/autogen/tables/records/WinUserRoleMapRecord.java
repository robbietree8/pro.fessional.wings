/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.warlock.database.autogen.tables.records;


import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;
import pro.fessional.wings.warlock.database.autogen.tables.WinUserRoleMapTable;
import pro.fessional.wings.warlock.database.autogen.tables.interfaces.IWinUserRoleMap;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


/**
 * The table <code>wings_warlock.win_user_role_map</code>.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4",
        "schema version:2020102402"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(
    name = "win_user_role_map",
    uniqueConstraints = {
        @UniqueConstraint(name = "KEY_win_user_role_map_PRIMARY", columnNames = { "refer_user", "grant_role" })
    }
)
public class WinUserRoleMapRecord extends UpdatableRecordImpl<WinUserRoleMapRecord> implements Record6<Long, Long, LocalDateTime, LocalDateTime, LocalDateTime, Long>, IWinUserRoleMap {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>win_user_role_map.refer_user</code>.
     */
    @Override
    public void setReferUser(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>win_user_role_map.refer_user</code>.
     */
    @Column(name = "refer_user", nullable = false, precision = 19)
    @NotNull
    @Override
    public Long getReferUser() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>win_user_role_map.grant_role</code>.
     */
    @Override
    public void setGrantRole(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>win_user_role_map.grant_role</code>.
     */
    @Column(name = "grant_role", nullable = false, precision = 19)
    @NotNull
    @Override
    public Long getGrantRole() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>win_user_role_map.create_dt</code>.
     */
    @Override
    public void setCreateDt(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>win_user_role_map.create_dt</code>.
     */
    @Column(name = "create_dt", nullable = false, precision = 3)
    @Override
    public LocalDateTime getCreateDt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>win_user_role_map.modify_dt</code>.
     */
    @Override
    public void setModifyDt(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>win_user_role_map.modify_dt</code>.
     */
    @Column(name = "modify_dt", nullable = false, precision = 3)
    @Override
    public LocalDateTime getModifyDt() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>win_user_role_map.delete_dt</code>.
     */
    @Override
    public void setDeleteDt(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>win_user_role_map.delete_dt</code>.
     */
    @Column(name = "delete_dt", nullable = false, precision = 3)
    @Override
    public LocalDateTime getDeleteDt() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>win_user_role_map.commit_id</code>.
     */
    @Override
    public void setCommitId(Long value) {
        set(5, value);
    }

    /**
     * Getter for <code>win_user_role_map.commit_id</code>.
     */
    @Column(name = "commit_id", nullable = false, precision = 19)
    @NotNull
    @Override
    public Long getCommitId() {
        return (Long) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Long, Long> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, Long, LocalDateTime, LocalDateTime, LocalDateTime, Long> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Long, Long, LocalDateTime, LocalDateTime, LocalDateTime, Long> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return WinUserRoleMapTable.WinUserRoleMap.ReferUser;
    }

    @Override
    public Field<Long> field2() {
        return WinUserRoleMapTable.WinUserRoleMap.GrantRole;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return WinUserRoleMapTable.WinUserRoleMap.CreateDt;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return WinUserRoleMapTable.WinUserRoleMap.ModifyDt;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return WinUserRoleMapTable.WinUserRoleMap.DeleteDt;
    }

    @Override
    public Field<Long> field6() {
        return WinUserRoleMapTable.WinUserRoleMap.CommitId;
    }

    @Override
    public Long component1() {
        return getReferUser();
    }

    @Override
    public Long component2() {
        return getGrantRole();
    }

    @Override
    public LocalDateTime component3() {
        return getCreateDt();
    }

    @Override
    public LocalDateTime component4() {
        return getModifyDt();
    }

    @Override
    public LocalDateTime component5() {
        return getDeleteDt();
    }

    @Override
    public Long component6() {
        return getCommitId();
    }

    @Override
    public Long value1() {
        return getReferUser();
    }

    @Override
    public Long value2() {
        return getGrantRole();
    }

    @Override
    public LocalDateTime value3() {
        return getCreateDt();
    }

    @Override
    public LocalDateTime value4() {
        return getModifyDt();
    }

    @Override
    public LocalDateTime value5() {
        return getDeleteDt();
    }

    @Override
    public Long value6() {
        return getCommitId();
    }

    @Override
    public WinUserRoleMapRecord value1(Long value) {
        setReferUser(value);
        return this;
    }

    @Override
    public WinUserRoleMapRecord value2(Long value) {
        setGrantRole(value);
        return this;
    }

    @Override
    public WinUserRoleMapRecord value3(LocalDateTime value) {
        setCreateDt(value);
        return this;
    }

    @Override
    public WinUserRoleMapRecord value4(LocalDateTime value) {
        setModifyDt(value);
        return this;
    }

    @Override
    public WinUserRoleMapRecord value5(LocalDateTime value) {
        setDeleteDt(value);
        return this;
    }

    @Override
    public WinUserRoleMapRecord value6(Long value) {
        setCommitId(value);
        return this;
    }

    @Override
    public WinUserRoleMapRecord values(Long value1, Long value2, LocalDateTime value3, LocalDateTime value4, LocalDateTime value5, Long value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IWinUserRoleMap from) {
        setReferUser(from.getReferUser());
        setGrantRole(from.getGrantRole());
        setCreateDt(from.getCreateDt());
        setModifyDt(from.getModifyDt());
        setDeleteDt(from.getDeleteDt());
        setCommitId(from.getCommitId());
    }

    @Override
    public <E extends IWinUserRoleMap> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached WinUserRoleMapRecord
     */
    public WinUserRoleMapRecord() {
        super(WinUserRoleMapTable.WinUserRoleMap);
    }

    /**
     * Create a detached, initialised WinUserRoleMapRecord
     */
    public WinUserRoleMapRecord(Long referUser, Long grantRole, LocalDateTime createDt, LocalDateTime modifyDt, LocalDateTime deleteDt, Long commitId) {
        super(WinUserRoleMapTable.WinUserRoleMap);

        setReferUser(referUser);
        setGrantRole(grantRole);
        setCreateDt(createDt);
        setModifyDt(modifyDt);
        setDeleteDt(deleteDt);
        setCommitId(commitId);
    }
}
