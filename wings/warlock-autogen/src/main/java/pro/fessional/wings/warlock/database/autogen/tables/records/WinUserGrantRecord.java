/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.warlock.database.autogen.tables.records;


import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;
import pro.fessional.wings.warlock.database.autogen.tables.WinUserGrantTable;
import pro.fessional.wings.warlock.database.autogen.tables.interfaces.IWinUserGrant;
import pro.fessional.wings.warlock.database.autogen.tables.pojos.WinUserGrant;
import pro.fessional.wings.warlock.enums.autogen.GrantType;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;


/**
 * The table <code>wings.win_user_grant</code>.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.17.7",
        "schema version:2020102701"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class WinUserGrantRecord extends UpdatableRecordImpl<WinUserGrantRecord> implements Record5<Long, GrantType, Long, LocalDateTime, Long>, IWinUserGrant {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>win_user_grant.refer_user</code>.
     */
    @Override
    public void setReferUser(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>win_user_grant.refer_user</code>.
     */
    @Override
    public Long getReferUser() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>win_user_grant.grant_type</code>.
     */
    @Override
    public void setGrantType(GrantType value) {
        set(1, value);
    }

    /**
     * Getter for <code>win_user_grant.grant_type</code>.
     */
    @Override
    public GrantType getGrantType() {
        return (GrantType) get(1);
    }

    /**
     * Setter for <code>win_user_grant.grant_entry</code>.
     */
    @Override
    public void setGrantEntry(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>win_user_grant.grant_entry</code>.
     */
    @Override
    public Long getGrantEntry() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>win_user_grant.create_dt</code>.
     */
    @Override
    public void setCreateDt(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>win_user_grant.create_dt</code>.
     */
    @Override
    public LocalDateTime getCreateDt() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>win_user_grant.commit_id</code>.
     */
    @Override
    public void setCommitId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>win_user_grant.commit_id</code>.
     */
    @Override
    public Long getCommitId() {
        return (Long) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record3<Long, GrantType, Long> key() {
        return (Record3) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, GrantType, Long, LocalDateTime, Long> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Long, GrantType, Long, LocalDateTime, Long> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return WinUserGrantTable.WinUserGrant.ReferUser;
    }

    @Override
    public Field<GrantType> field2() {
        return WinUserGrantTable.WinUserGrant.GrantType;
    }

    @Override
    public Field<Long> field3() {
        return WinUserGrantTable.WinUserGrant.GrantEntry;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return WinUserGrantTable.WinUserGrant.CreateDt;
    }

    @Override
    public Field<Long> field5() {
        return WinUserGrantTable.WinUserGrant.CommitId;
    }

    @Override
    public Long component1() {
        return getReferUser();
    }

    @Override
    public GrantType component2() {
        return getGrantType();
    }

    @Override
    public Long component3() {
        return getGrantEntry();
    }

    @Override
    public LocalDateTime component4() {
        return getCreateDt();
    }

    @Override
    public Long component5() {
        return getCommitId();
    }

    @Override
    public Long value1() {
        return getReferUser();
    }

    @Override
    public GrantType value2() {
        return getGrantType();
    }

    @Override
    public Long value3() {
        return getGrantEntry();
    }

    @Override
    public LocalDateTime value4() {
        return getCreateDt();
    }

    @Override
    public Long value5() {
        return getCommitId();
    }

    @Override
    public WinUserGrantRecord value1(Long value) {
        setReferUser(value);
        return this;
    }

    @Override
    public WinUserGrantRecord value2(GrantType value) {
        setGrantType(value);
        return this;
    }

    @Override
    public WinUserGrantRecord value3(Long value) {
        setGrantEntry(value);
        return this;
    }

    @Override
    public WinUserGrantRecord value4(LocalDateTime value) {
        setCreateDt(value);
        return this;
    }

    @Override
    public WinUserGrantRecord value5(Long value) {
        setCommitId(value);
        return this;
    }

    @Override
    public WinUserGrantRecord values(Long value1, GrantType value2, Long value3, LocalDateTime value4, Long value5) {
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
    public void from(IWinUserGrant from) {
        setReferUser(from.getReferUser());
        setGrantType(from.getGrantType());
        setGrantEntry(from.getGrantEntry());
        setCreateDt(from.getCreateDt());
        setCommitId(from.getCommitId());
    }

    @Override
    public <E extends IWinUserGrant> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached WinUserGrantRecord
     */
    public WinUserGrantRecord() {
        super(WinUserGrantTable.WinUserGrant);
    }

    /**
     * Create a detached, initialised WinUserGrantRecord
     */
    public WinUserGrantRecord(Long referUser, GrantType grantType, Long grantEntry, LocalDateTime createDt, Long commitId) {
        super(WinUserGrantTable.WinUserGrant);

        setReferUser(referUser);
        setGrantType(grantType);
        setGrantEntry(grantEntry);
        setCreateDt(createDt);
        setCommitId(commitId);
    }

    /**
     * Create a detached, initialised WinUserGrantRecord
     */
    public WinUserGrantRecord(WinUserGrant value) {
        super(WinUserGrantTable.WinUserGrant);

        if (value != null) {
            setReferUser(value.getReferUser());
            setGrantType(value.getGrantType());
            setGrantEntry(value.getGrantEntry());
            setCreateDt(value.getCreateDt());
            setCommitId(value.getCommitId());
        }
    }
}
