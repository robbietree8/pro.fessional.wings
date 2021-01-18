/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.faceless.database.autogen.tables.interfaces;


import pro.fessional.wings.faceless.enums.auto.StandardLanguage;
import pro.fessional.wings.faceless.service.journal.JournalAware;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
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
public interface ITst中文也分表 extends JournalAware, Serializable {

    /**
     * Setter for <code>tst_中文也分表.id</code>.
     */
    public void setId(Long value);

    /**
     * Getter for <code>tst_中文也分表.id</code>.
     */
    @Id
    @Column(name = "id", nullable = false, precision = 19)
    @NotNull
    public Long getId();

    /**
     * Setter for <code>tst_中文也分表.create_dt</code>.
     */
    public void setCreateDt(LocalDateTime value);

    /**
     * Getter for <code>tst_中文也分表.create_dt</code>.
     */
    @Column(name = "create_dt", nullable = false, precision = 3)
    public LocalDateTime getCreateDt();

    /**
     * Setter for <code>tst_中文也分表.modify_dt</code>.
     */
    public void setModifyDt(LocalDateTime value);

    /**
     * Getter for <code>tst_中文也分表.modify_dt</code>.
     */
    @Column(name = "modify_dt", nullable = false, precision = 3)
    public LocalDateTime getModifyDt();

    /**
     * Setter for <code>tst_中文也分表.delete_dt</code>.
     */
    public void setDeleteDt(LocalDateTime value);

    /**
     * Getter for <code>tst_中文也分表.delete_dt</code>.
     */
    @Column(name = "delete_dt", nullable = false, precision = 3)
    public LocalDateTime getDeleteDt();

    /**
     * Setter for <code>tst_中文也分表.commit_id</code>.
     */
    public void setCommitId(Long value);

    /**
     * Getter for <code>tst_中文也分表.commit_id</code>.
     */
    @Column(name = "commit_id", nullable = false, precision = 19)
    @NotNull
    public Long getCommitId();

    /**
     * Setter for <code>tst_中文也分表.login_info</code>.
     */
    public void setLoginInfo(String value);

    /**
     * Getter for <code>tst_中文也分表.login_info</code>.
     */
    @Column(name = "login_info", length = 65535)
    @Size(max = 65535)
    public String getLoginInfo();

    /**
     * Setter for <code>tst_中文也分表.other_info</code>.
     */
    public void setOtherInfo(String value);

    /**
     * Getter for <code>tst_中文也分表.other_info</code>.
     */
    @Column(name = "other_info", length = 65535)
    @Size(max = 65535)
    public String getOtherInfo();

    /**
     * Setter for <code>tst_中文也分表.language</code>.
     */
    public void setLanguage(StandardLanguage value);

    /**
     * Getter for <code>tst_中文也分表.language</code>.
     */
    @Column(name = "language", nullable = false, precision = 10)
    public StandardLanguage getLanguage();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface ITst中文也分表
     */
    public void from(ITst中文也分表 from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface ITst中文也分表
     */
    public <E extends ITst中文也分表> E into(E into);
}
