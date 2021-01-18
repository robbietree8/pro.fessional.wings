/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.faceless.database.autogen.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;
import pro.fessional.wings.faceless.database.autogen.tables.Tst中文也分表Table;
import pro.fessional.wings.faceless.database.autogen.tables.interfaces.ITst中文也分表;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


/**
 * The table <code>wings.tst_中文也分表</code>.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4",
        "schema version:2019060102"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(
    name = "tst_中文也分表",
    uniqueConstraints = {
        @UniqueConstraint(name = "KEY_tst_中文也分表_PRIMARY", columnNames = { "id" })
    }
)
public class Tst中文也分表Record extends UpdatableRecordImpl<Tst中文也分表Record> implements Record8<Long, LocalDateTime, LocalDateTime, LocalDateTime, Long, String, String, Integer>, ITst中文也分表 {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>tst_中文也分表.id</code>.
     */
    @Override
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>tst_中文也分表.id</code>.
     */
    @Id
    @Column(name = "id", nullable = false, precision = 19)
    @NotNull
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>tst_中文也分表.create_dt</code>.
     */
    @Override
    public void setCreateDt(LocalDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>tst_中文也分表.create_dt</code>.
     */
    @Column(name = "create_dt", nullable = false, precision = 3)
    @Override
    public LocalDateTime getCreateDt() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>tst_中文也分表.modify_dt</code>.
     */
    @Override
    public void setModifyDt(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>tst_中文也分表.modify_dt</code>.
     */
    @Column(name = "modify_dt", nullable = false, precision = 3)
    @Override
    public LocalDateTime getModifyDt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>tst_中文也分表.delete_dt</code>.
     */
    @Override
    public void setDeleteDt(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>tst_中文也分表.delete_dt</code>.
     */
    @Column(name = "delete_dt", nullable = false, precision = 3)
    @Override
    public LocalDateTime getDeleteDt() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>tst_中文也分表.commit_id</code>.
     */
    @Override
    public void setCommitId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>tst_中文也分表.commit_id</code>.
     */
    @Column(name = "commit_id", nullable = false, precision = 19)
    @NotNull
    @Override
    public Long getCommitId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>tst_中文也分表.login_info</code>.
     */
    @Override
    public void setLoginInfo(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>tst_中文也分表.login_info</code>.
     */
    @Column(name = "login_info", length = 65535)
    @Size(max = 65535)
    @Override
    public String getLoginInfo() {
        return (String) get(5);
    }

    /**
     * Setter for <code>tst_中文也分表.other_info</code>.
     */
    @Override
    public void setOtherInfo(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>tst_中文也分表.other_info</code>.
     */
    @Column(name = "other_info", length = 65535)
    @Size(max = 65535)
    @Override
    public String getOtherInfo() {
        return (String) get(6);
    }

    /**
     * Setter for <code>tst_中文也分表.language</code>.
     */
    @Override
    public void setLanguage(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>tst_中文也分表.language</code>.
     */
    @Column(name = "language", nullable = false, precision = 10)
    @Override
    public Integer getLanguage() {
        return (Integer) get(7);
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
    public Row8<Long, LocalDateTime, LocalDateTime, LocalDateTime, Long, String, String, Integer> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<Long, LocalDateTime, LocalDateTime, LocalDateTime, Long, String, String, Integer> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Tst中文也分表Table.Tst中文也分表.Id;
    }

    @Override
    public Field<LocalDateTime> field2() {
        return Tst中文也分表Table.Tst中文也分表.CreateDt;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return Tst中文也分表Table.Tst中文也分表.ModifyDt;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return Tst中文也分表Table.Tst中文也分表.DeleteDt;
    }

    @Override
    public Field<Long> field5() {
        return Tst中文也分表Table.Tst中文也分表.CommitId;
    }

    @Override
    public Field<String> field6() {
        return Tst中文也分表Table.Tst中文也分表.LoginInfo;
    }

    @Override
    public Field<String> field7() {
        return Tst中文也分表Table.Tst中文也分表.OtherInfo;
    }

    @Override
    public Field<Integer> field8() {
        return Tst中文也分表Table.Tst中文也分表.Language;
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
        return getLoginInfo();
    }

    @Override
    public String component7() {
        return getOtherInfo();
    }

    @Override
    public Integer component8() {
        return getLanguage();
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
        return getLoginInfo();
    }

    @Override
    public String value7() {
        return getOtherInfo();
    }

    @Override
    public Integer value8() {
        return getLanguage();
    }

    @Override
    public Tst中文也分表Record value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public Tst中文也分表Record value2(LocalDateTime value) {
        setCreateDt(value);
        return this;
    }

    @Override
    public Tst中文也分表Record value3(LocalDateTime value) {
        setModifyDt(value);
        return this;
    }

    @Override
    public Tst中文也分表Record value4(LocalDateTime value) {
        setDeleteDt(value);
        return this;
    }

    @Override
    public Tst中文也分表Record value5(Long value) {
        setCommitId(value);
        return this;
    }

    @Override
    public Tst中文也分表Record value6(String value) {
        setLoginInfo(value);
        return this;
    }

    @Override
    public Tst中文也分表Record value7(String value) {
        setOtherInfo(value);
        return this;
    }

    @Override
    public Tst中文也分表Record value8(Integer value) {
        setLanguage(value);
        return this;
    }

    @Override
    public Tst中文也分表Record values(Long value1, LocalDateTime value2, LocalDateTime value3, LocalDateTime value4, Long value5, String value6, String value7, Integer value8) {
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
    public void from(ITst中文也分表 from) {
        setId(from.getId());
        setCreateDt(from.getCreateDt());
        setModifyDt(from.getModifyDt());
        setDeleteDt(from.getDeleteDt());
        setCommitId(from.getCommitId());
        setLoginInfo(from.getLoginInfo());
        setOtherInfo(from.getOtherInfo());
        setLanguage(from.getLanguage());
    }

    @Override
    public <E extends ITst中文也分表> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached Tst中文也分表Record
     */
    public Tst中文也分表Record() {
        super(Tst中文也分表Table.Tst中文也分表);
    }

    /**
     * Create a detached, initialised Tst中文也分表Record
     */
    public Tst中文也分表Record(Long id, LocalDateTime createDt, LocalDateTime modifyDt, LocalDateTime deleteDt, Long commitId, String loginInfo, String otherInfo, Integer language) {
        super(Tst中文也分表Table.Tst中文也分表);

        setId(id);
        setCreateDt(createDt);
        setModifyDt(modifyDt);
        setDeleteDt(deleteDt);
        setCommitId(commitId);
        setLoginInfo(loginInfo);
        setOtherInfo(otherInfo);
        setLanguage(language);
    }
}
