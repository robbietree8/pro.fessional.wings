/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.faceless.database.autogen.tables.interfaces;


import pro.fessional.wings.faceless.service.journal.JournalAware;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * The table <code>wings.tst_中文也分表</code>.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface ITst中文也分表 extends JournalAware, Serializable {

    /**
     * Setter for <code>tst_中文也分表.id</code>.
     */
    public void setId(Long value);

    /**
     * Getter for <code>tst_中文也分表.id</code>.
     */
    public Long getId();

    /**
     * Setter for <code>tst_中文也分表.create_dt</code>.
     */
    public void setCreateDt(LocalDateTime value);

    /**
     * Getter for <code>tst_中文也分表.create_dt</code>.
     */
    public LocalDateTime getCreateDt();

    /**
     * Setter for <code>tst_中文也分表.modify_dt</code>.
     */
    public void setModifyDt(LocalDateTime value);

    /**
     * Getter for <code>tst_中文也分表.modify_dt</code>.
     */
    public LocalDateTime getModifyDt();

    /**
     * Setter for <code>tst_中文也分表.delete_dt</code>.
     */
    public void setDeleteDt(LocalDateTime value);

    /**
     * Getter for <code>tst_中文也分表.delete_dt</code>.
     */
    public LocalDateTime getDeleteDt();

    /**
     * Setter for <code>tst_中文也分表.commit_id</code>.
     */
    public void setCommitId(Long value);

    /**
     * Getter for <code>tst_中文也分表.commit_id</code>.
     */
    public Long getCommitId();

    /**
     * Setter for <code>tst_中文也分表.login_info</code>.
     */
    public void setLoginInfo(String value);

    /**
     * Getter for <code>tst_中文也分表.login_info</code>.
     */
    public String getLoginInfo();

    /**
     * Setter for <code>tst_中文也分表.other_info</code>.
     */
    public void setOtherInfo(String value);

    /**
     * Getter for <code>tst_中文也分表.other_info</code>.
     */
    public String getOtherInfo();

    /**
     * Setter for <code>tst_中文也分表.language</code>.
     */
    public void setLanguage(Integer value);

    /**
     * Getter for <code>tst_中文也分表.language</code>.
     */
    public Integer getLanguage();

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
