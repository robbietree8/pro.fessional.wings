/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.warlock.database.autogen.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;
import pro.fessional.wings.warlock.database.autogen.tables.WinPermEntryTable;
import pro.fessional.wings.warlock.database.autogen.tables.interfaces.IWinPermEntry;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;


/**
 * The table <code>wings_warlock.win_perm_entry</code>.
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
public class WinPermEntryRecord extends UpdatableRecordImpl<WinPermEntryRecord> implements Record8<Long, LocalDateTime, LocalDateTime, LocalDateTime, Long, String, String, String>, IWinPermEntry {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>win_perm_entry.id</code>.
     */
    @Override
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>win_perm_entry.id</code>.
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>win_perm_entry.create_dt</code>.
     */
    @Override
    public void setCreateDt(LocalDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>win_perm_entry.create_dt</code>.
     */
    @Override
    public LocalDateTime getCreateDt() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>win_perm_entry.modify_dt</code>.
     */
    @Override
    public void setModifyDt(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>win_perm_entry.modify_dt</code>.
     */
    @Override
    public LocalDateTime getModifyDt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>win_perm_entry.delete_dt</code>.
     */
    @Override
    public void setDeleteDt(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>win_perm_entry.delete_dt</code>.
     */
    @Override
    public LocalDateTime getDeleteDt() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>win_perm_entry.commit_id</code>.
     */
    @Override
    public void setCommitId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>win_perm_entry.commit_id</code>.
     */
    @Override
    public Long getCommitId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>win_perm_entry.scopes</code>.
     */
    @Override
    public void setScopes(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>win_perm_entry.scopes</code>.
     */
    @Override
    public String getScopes() {
        return (String) get(5);
    }

    /**
     * Setter for <code>win_perm_entry.action</code>.
     */
    @Override
    public void setAction(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>win_perm_entry.action</code>.
     */
    @Override
    public String getAction() {
        return (String) get(6);
    }

    /**
     * Setter for <code>win_perm_entry.remark</code>.
     */
    @Override
    public void setRemark(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>win_perm_entry.remark</code>.
     */
    @Override
    public String getRemark() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, LocalDateTime, LocalDateTime, LocalDateTime, Long, String, String, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<Long, LocalDateTime, LocalDateTime, LocalDateTime, Long, String, String, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return WinPermEntryTable.WinPermEntry.Id;
    }

    @Override
    public Field<LocalDateTime> field2() {
        return WinPermEntryTable.WinPermEntry.CreateDt;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return WinPermEntryTable.WinPermEntry.ModifyDt;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return WinPermEntryTable.WinPermEntry.DeleteDt;
    }

    @Override
    public Field<Long> field5() {
        return WinPermEntryTable.WinPermEntry.CommitId;
    }

    @Override
    public Field<String> field6() {
        return WinPermEntryTable.WinPermEntry.Scopes;
    }

    @Override
    public Field<String> field7() {
        return WinPermEntryTable.WinPermEntry.Action;
    }

    @Override
    public Field<String> field8() {
        return WinPermEntryTable.WinPermEntry.Remark;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public LocalDateTime component2() {
        return getCreateDt();
    }

    @Override
    public LocalDateTime component3() {
        return getModifyDt();
    }

    @Override
    public LocalDateTime component4() {
        return getDeleteDt();
    }

    @Override
    public Long component5() {
        return getCommitId();
    }

    @Override
    public String component6() {
        return getScopes();
    }

    @Override
    public String component7() {
        return getAction();
    }

    @Override
    public String component8() {
        return getRemark();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public LocalDateTime value2() {
        return getCreateDt();
    }

    @Override
    public LocalDateTime value3() {
        return getModifyDt();
    }

    @Override
    public LocalDateTime value4() {
        return getDeleteDt();
    }

    @Override
    public Long value5() {
        return getCommitId();
    }

    @Override
    public String value6() {
        return getScopes();
    }

    @Override
    public String value7() {
        return getAction();
    }

    @Override
    public String value8() {
        return getRemark();
    }

    @Override
    public WinPermEntryRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public WinPermEntryRecord value2(LocalDateTime value) {
        setCreateDt(value);
        return this;
    }

    @Override
    public WinPermEntryRecord value3(LocalDateTime value) {
        setModifyDt(value);
        return this;
    }

    @Override
    public WinPermEntryRecord value4(LocalDateTime value) {
        setDeleteDt(value);
        return this;
    }

    @Override
    public WinPermEntryRecord value5(Long value) {
        setCommitId(value);
        return this;
    }

    @Override
    public WinPermEntryRecord value6(String value) {
        setScopes(value);
        return this;
    }

    @Override
    public WinPermEntryRecord value7(String value) {
        setAction(value);
        return this;
    }

    @Override
    public WinPermEntryRecord value8(String value) {
        setRemark(value);
        return this;
    }

    @Override
    public WinPermEntryRecord values(Long value1, LocalDateTime value2, LocalDateTime value3, LocalDateTime value4, Long value5, String value6, String value7, String value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IWinPermEntry from) {
        setId(from.getId());
        setCreateDt(from.getCreateDt());
        setModifyDt(from.getModifyDt());
        setDeleteDt(from.getDeleteDt());
        setCommitId(from.getCommitId());
        setScopes(from.getScopes());
        setAction(from.getAction());
        setRemark(from.getRemark());
    }

    @Override
    public <E extends IWinPermEntry> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached WinPermEntryRecord
     */
    public WinPermEntryRecord() {
        super(WinPermEntryTable.WinPermEntry);
    }

    /**
     * Create a detached, initialised WinPermEntryRecord
     */
    public WinPermEntryRecord(Long id, LocalDateTime createDt, LocalDateTime modifyDt, LocalDateTime deleteDt, Long commitId, String scopes, String action, String remark) {
        super(WinPermEntryTable.WinPermEntry);

        setId(id);
        setCreateDt(createDt);
        setModifyDt(modifyDt);
        setDeleteDt(deleteDt);
        setCommitId(commitId);
        setScopes(scopes);
        setAction(action);
        setRemark(remark);
    }
}
