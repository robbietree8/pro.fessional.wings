/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.example.database.autogen.tables.records;


import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record15;
import org.jooq.Row15;
import org.jooq.impl.UpdatableRecordImpl;

import pro.fessional.wings.example.database.autogen.tables.WinUserTable;
import pro.fessional.wings.example.database.autogen.tables.interfaces.IWinUser;


/**
 * The table <code>wings_example.win_user</code>.
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
@Table(name = "win_user", uniqueConstraints = {
    @UniqueConstraint(name = "KEY_win_user_PRIMARY", columnNames = {"id"})
})
public class WinUserRecord extends UpdatableRecordImpl<WinUserRecord> implements Record15<Long, LocalDateTime, LocalDateTime, LocalDateTime, Long, String, Integer, LocalDate, String, String, String, Integer, String, String, Integer>, IWinUser {

    private static final long serialVersionUID = 2022554037;

    /**
     * Setter for <code>win_user.id</code>.
     */
    @Override
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>win_user.id</code>.
     */
    @Id
    @Column(name = "id", nullable = false, precision = 19)
    @NotNull
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>win_user.create_dt</code>.
     */
    @Override
    public void setCreateDt(LocalDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>win_user.create_dt</code>.
     */
    @Column(name = "create_dt", nullable = false)
    @Override
    public LocalDateTime getCreateDt() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>win_user.modify_dt</code>.
     */
    @Override
    public void setModifyDt(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>win_user.modify_dt</code>.
     */
    @Column(name = "modify_dt", nullable = false)
    @Override
    public LocalDateTime getModifyDt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>win_user.delete_dt</code>.
     */
    @Override
    public void setDeleteDt(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>win_user.delete_dt</code>.
     */
    @Column(name = "delete_dt", nullable = false)
    @Override
    public LocalDateTime getDeleteDt() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>win_user.commit_id</code>.
     */
    @Override
    public void setCommitId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>win_user.commit_id</code>.
     */
    @Column(name = "commit_id", nullable = false, precision = 19)
    @NotNull
    @Override
    public Long getCommitId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>win_user.name</code>.
     */
    @Override
    public void setName(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>win_user.name</code>.
     */
    @Column(name = "name", nullable = false, length = 50)
    @NotNull
    @Size(max = 50)
    @Override
    public String getName() {
        return (String) get(5);
    }

    /**
     * Setter for <code>win_user.gender</code>.
     */
    @Override
    public void setGender(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>win_user.gender</code>.
     */
    @Column(name = "gender", nullable = false, precision = 10)
    @NotNull
    @Override
    public Integer getGender() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>win_user.birth</code>.
     */
    @Override
    public void setBirth(LocalDate value) {
        set(7, value);
    }

    /**
     * Getter for <code>win_user.birth</code>.
     */
    @Column(name = "birth", nullable = false)
    @NotNull
    @Override
    public LocalDate getBirth() {
        return (LocalDate) get(7);
    }

    /**
     * Setter for <code>win_user.avatar</code>.
     */
    @Override
    public void setAvatar(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>win_user.avatar</code>.
     */
    @Column(name = "avatar", nullable = false, length = 200)
    @NotNull
    @Size(max = 200)
    @Override
    public String getAvatar() {
        return (String) get(8);
    }

    /**
     * Setter for <code>win_user.country</code>.
     */
    @Override
    public void setCountry(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>win_user.country</code>.
     */
    @Column(name = "country", nullable = false, length = 2)
    @NotNull
    @Size(max = 2)
    @Override
    public String getCountry() {
        return (String) get(9);
    }

    /**
     * Setter for <code>win_user.language</code>.
     */
    @Override
    public void setLanguage(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>win_user.language</code>.
     */
    @Column(name = "language", nullable = false, length = 5)
    @NotNull
    @Size(max = 5)
    @Override
    public String getLanguage() {
        return (String) get(10);
    }

    /**
     * Setter for <code>win_user.timezone</code>.
     */
    @Override
    public void setTimezone(Integer value) {
        set(11, value);
    }

    /**
     * Getter for <code>win_user.timezone</code>.
     */
    @Column(name = "timezone", nullable = false, precision = 10)
    @NotNull
    @Override
    public Integer getTimezone() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>win_user.auth_set</code>.
     */
    @Override
    public void setAuthSet(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>win_user.auth_set</code>.
     */
    @Column(name = "auth_set", nullable = false, length = 2000)
    @Size(max = 2000)
    @Override
    public String getAuthSet() {
        return (String) get(12);
    }

    /**
     * Setter for <code>win_user.role_set</code>.
     */
    @Override
    public void setRoleSet(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>win_user.role_set</code>.
     */
    @Column(name = "role_set", nullable = false, length = 1000)
    @Size(max = 1000)
    @Override
    public String getRoleSet() {
        return (String) get(13);
    }

    /**
     * Setter for <code>win_user.status</code>.
     */
    @Override
    public void setStatus(Integer value) {
        set(14, value);
    }

    /**
     * Getter for <code>win_user.status</code>.
     */
    @Column(name = "status", nullable = false, precision = 10)
    @NotNull
    @Override
    public Integer getStatus() {
        return (Integer) get(14);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record15 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row15<Long, LocalDateTime, LocalDateTime, LocalDateTime, Long, String, Integer, LocalDate, String, String, String, Integer, String, String, Integer> fieldsRow() {
        return (Row15) super.fieldsRow();
    }

    @Override
    public Row15<Long, LocalDateTime, LocalDateTime, LocalDateTime, Long, String, Integer, LocalDate, String, String, String, Integer, String, String, Integer> valuesRow() {
        return (Row15) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return WinUserTable.WinUser.Id;
    }

    @Override
    public Field<LocalDateTime> field2() {
        return WinUserTable.WinUser.CreateDt;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return WinUserTable.WinUser.ModifyDt;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return WinUserTable.WinUser.DeleteDt;
    }

    @Override
    public Field<Long> field5() {
        return WinUserTable.WinUser.CommitId;
    }

    @Override
    public Field<String> field6() {
        return WinUserTable.WinUser.Name;
    }

    @Override
    public Field<Integer> field7() {
        return WinUserTable.WinUser.Gender;
    }

    @Override
    public Field<LocalDate> field8() {
        return WinUserTable.WinUser.Birth;
    }

    @Override
    public Field<String> field9() {
        return WinUserTable.WinUser.Avatar;
    }

    @Override
    public Field<String> field10() {
        return WinUserTable.WinUser.Country;
    }

    @Override
    public Field<String> field11() {
        return WinUserTable.WinUser.Language;
    }

    @Override
    public Field<Integer> field12() {
        return WinUserTable.WinUser.Timezone;
    }

    @Override
    public Field<String> field13() {
        return WinUserTable.WinUser.AuthSet;
    }

    @Override
    public Field<String> field14() {
        return WinUserTable.WinUser.RoleSet;
    }

    @Override
    public Field<Integer> field15() {
        return WinUserTable.WinUser.Status;
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
        return getName();
    }

    @Override
    public Integer component7() {
        return getGender();
    }

    @Override
    public LocalDate component8() {
        return getBirth();
    }

    @Override
    public String component9() {
        return getAvatar();
    }

    @Override
    public String component10() {
        return getCountry();
    }

    @Override
    public String component11() {
        return getLanguage();
    }

    @Override
    public Integer component12() {
        return getTimezone();
    }

    @Override
    public String component13() {
        return getAuthSet();
    }

    @Override
    public String component14() {
        return getRoleSet();
    }

    @Override
    public Integer component15() {
        return getStatus();
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
        return getName();
    }

    @Override
    public Integer value7() {
        return getGender();
    }

    @Override
    public LocalDate value8() {
        return getBirth();
    }

    @Override
    public String value9() {
        return getAvatar();
    }

    @Override
    public String value10() {
        return getCountry();
    }

    @Override
    public String value11() {
        return getLanguage();
    }

    @Override
    public Integer value12() {
        return getTimezone();
    }

    @Override
    public String value13() {
        return getAuthSet();
    }

    @Override
    public String value14() {
        return getRoleSet();
    }

    @Override
    public Integer value15() {
        return getStatus();
    }

    @Override
    public WinUserRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public WinUserRecord value2(LocalDateTime value) {
        setCreateDt(value);
        return this;
    }

    @Override
    public WinUserRecord value3(LocalDateTime value) {
        setModifyDt(value);
        return this;
    }

    @Override
    public WinUserRecord value4(LocalDateTime value) {
        setDeleteDt(value);
        return this;
    }

    @Override
    public WinUserRecord value5(Long value) {
        setCommitId(value);
        return this;
    }

    @Override
    public WinUserRecord value6(String value) {
        setName(value);
        return this;
    }

    @Override
    public WinUserRecord value7(Integer value) {
        setGender(value);
        return this;
    }

    @Override
    public WinUserRecord value8(LocalDate value) {
        setBirth(value);
        return this;
    }

    @Override
    public WinUserRecord value9(String value) {
        setAvatar(value);
        return this;
    }

    @Override
    public WinUserRecord value10(String value) {
        setCountry(value);
        return this;
    }

    @Override
    public WinUserRecord value11(String value) {
        setLanguage(value);
        return this;
    }

    @Override
    public WinUserRecord value12(Integer value) {
        setTimezone(value);
        return this;
    }

    @Override
    public WinUserRecord value13(String value) {
        setAuthSet(value);
        return this;
    }

    @Override
    public WinUserRecord value14(String value) {
        setRoleSet(value);
        return this;
    }

    @Override
    public WinUserRecord value15(Integer value) {
        setStatus(value);
        return this;
    }

    @Override
    public WinUserRecord values(Long value1, LocalDateTime value2, LocalDateTime value3, LocalDateTime value4, Long value5, String value6, Integer value7, LocalDate value8, String value9, String value10, String value11, Integer value12, String value13, String value14, Integer value15) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IWinUser from) {
        setId(from.getId());
        setCreateDt(from.getCreateDt());
        setModifyDt(from.getModifyDt());
        setDeleteDt(from.getDeleteDt());
        setCommitId(from.getCommitId());
        setName(from.getName());
        setGender(from.getGender());
        setBirth(from.getBirth());
        setAvatar(from.getAvatar());
        setCountry(from.getCountry());
        setLanguage(from.getLanguage());
        setTimezone(from.getTimezone());
        setAuthSet(from.getAuthSet());
        setRoleSet(from.getRoleSet());
        setStatus(from.getStatus());
    }

    @Override
    public <E extends IWinUser> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached WinUserRecord
     */
    public WinUserRecord() {
        super(WinUserTable.WinUser);
    }

    /**
     * Create a detached, initialised WinUserRecord
     */
    public WinUserRecord(Long id, LocalDateTime createDt, LocalDateTime modifyDt, LocalDateTime deleteDt, Long commitId, String name, Integer gender, LocalDate birth, String avatar, String country, String language, Integer timezone, String authSet, String roleSet, Integer status) {
        super(WinUserTable.WinUser);

        set(0, id);
        set(1, createDt);
        set(2, modifyDt);
        set(3, deleteDt);
        set(4, commitId);
        set(5, name);
        set(6, gender);
        set(7, birth);
        set(8, avatar);
        set(9, country);
        set(10, language);
        set(11, timezone);
        set(12, authSet);
        set(13, roleSet);
        set(14, status);
    }
}
