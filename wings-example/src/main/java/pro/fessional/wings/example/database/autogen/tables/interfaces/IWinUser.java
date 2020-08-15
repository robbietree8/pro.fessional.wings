/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.example.database.autogen.tables.interfaces;


import java.io.Serializable;
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

import pro.fessional.wings.faceless.service.journal.JournalAware;


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
public interface IWinUser extends JournalAware, Serializable {

    /**
     * Setter for <code>win_user.id</code>.
     */
    public void setId(Long value);

    /**
     * Getter for <code>win_user.id</code>.
     */
    @Id
    @Column(name = "id", nullable = false, precision = 19)
    @NotNull
    public Long getId();

    /**
     * Setter for <code>win_user.create_dt</code>.
     */
    public void setCreateDt(LocalDateTime value);

    /**
     * Getter for <code>win_user.create_dt</code>.
     */
    @Column(name = "create_dt", nullable = false)
    public LocalDateTime getCreateDt();

    /**
     * Setter for <code>win_user.modify_dt</code>.
     */
    public void setModifyDt(LocalDateTime value);

    /**
     * Getter for <code>win_user.modify_dt</code>.
     */
    @Column(name = "modify_dt", nullable = false)
    public LocalDateTime getModifyDt();

    /**
     * Setter for <code>win_user.delete_dt</code>.
     */
    public void setDeleteDt(LocalDateTime value);

    /**
     * Getter for <code>win_user.delete_dt</code>.
     */
    @Column(name = "delete_dt", nullable = false)
    public LocalDateTime getDeleteDt();

    /**
     * Setter for <code>win_user.commit_id</code>.
     */
    public void setCommitId(Long value);

    /**
     * Getter for <code>win_user.commit_id</code>.
     */
    @Column(name = "commit_id", nullable = false, precision = 19)
    @NotNull
    public Long getCommitId();

    /**
     * Setter for <code>win_user.name</code>.
     */
    public void setName(String value);

    /**
     * Getter for <code>win_user.name</code>.
     */
    @Column(name = "name", nullable = false, length = 50)
    @NotNull
    @Size(max = 50)
    public String getName();

    /**
     * Setter for <code>win_user.gender</code>.
     */
    public void setGender(Integer value);

    /**
     * Getter for <code>win_user.gender</code>.
     */
    @Column(name = "gender", nullable = false, precision = 10)
    @NotNull
    public Integer getGender();

    /**
     * Setter for <code>win_user.birth</code>.
     */
    public void setBirth(LocalDate value);

    /**
     * Getter for <code>win_user.birth</code>.
     */
    @Column(name = "birth", nullable = false)
    @NotNull
    public LocalDate getBirth();

    /**
     * Setter for <code>win_user.avatar</code>.
     */
    public void setAvatar(String value);

    /**
     * Getter for <code>win_user.avatar</code>.
     */
    @Column(name = "avatar", nullable = false, length = 200)
    @NotNull
    @Size(max = 200)
    public String getAvatar();

    /**
     * Setter for <code>win_user.country</code>.
     */
    public void setCountry(String value);

    /**
     * Getter for <code>win_user.country</code>.
     */
    @Column(name = "country", nullable = false, length = 2)
    @NotNull
    @Size(max = 2)
    public String getCountry();

    /**
     * Setter for <code>win_user.language</code>.
     */
    public void setLanguage(String value);

    /**
     * Getter for <code>win_user.language</code>.
     */
    @Column(name = "language", nullable = false, length = 5)
    @NotNull
    @Size(max = 5)
    public String getLanguage();

    /**
     * Setter for <code>win_user.timezone</code>.
     */
    public void setTimezone(Integer value);

    /**
     * Getter for <code>win_user.timezone</code>.
     */
    @Column(name = "timezone", nullable = false, precision = 10)
    @NotNull
    public Integer getTimezone();

    /**
     * Setter for <code>win_user.auth_set</code>.
     */
    public void setAuthSet(String value);

    /**
     * Getter for <code>win_user.auth_set</code>.
     */
    @Column(name = "auth_set", nullable = false, length = 2000)
    @Size(max = 2000)
    public String getAuthSet();

    /**
     * Setter for <code>win_user.role_set</code>.
     */
    public void setRoleSet(String value);

    /**
     * Getter for <code>win_user.role_set</code>.
     */
    @Column(name = "role_set", nullable = false, length = 1000)
    @Size(max = 1000)
    public String getRoleSet();

    /**
     * Setter for <code>win_user.status</code>.
     */
    public void setStatus(Integer value);

    /**
     * Getter for <code>win_user.status</code>.
     */
    @Column(name = "status", nullable = false, precision = 10)
    @NotNull
    public Integer getStatus();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IWinUser
     */
    public void from(pro.fessional.wings.example.database.autogen.tables.interfaces.IWinUser from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IWinUser
     */
    public <E extends pro.fessional.wings.example.database.autogen.tables.interfaces.IWinUser> E into(E into);
}
