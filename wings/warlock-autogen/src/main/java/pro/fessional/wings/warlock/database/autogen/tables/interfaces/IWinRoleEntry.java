/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.warlock.database.autogen.tables.interfaces;


import pro.fessional.wings.faceless.service.journal.JournalAware;

import javax.annotation.processing.Generated;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * The table <code>wings.win_role_entry</code>.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.18.7",
        "schema version:2020102701"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public interface IWinRoleEntry extends JournalAware, Serializable {

    /**
     * Setter for <code>win_role_entry.id</code>.
     */
    public void setId(Long value);

    /**
     * Getter for <code>win_role_entry.id</code>.
     */
    public Long getId();

    /**
     * Setter for <code>win_role_entry.create_dt</code>.
     */
    public void setCreateDt(LocalDateTime value);

    /**
     * Getter for <code>win_role_entry.create_dt</code>.
     */
    public LocalDateTime getCreateDt();

    /**
     * Setter for <code>win_role_entry.modify_dt</code>.
     */
    public void setModifyDt(LocalDateTime value);

    /**
     * Getter for <code>win_role_entry.modify_dt</code>.
     */
    public LocalDateTime getModifyDt();

    /**
     * Setter for <code>win_role_entry.delete_dt</code>.
     */
    public void setDeleteDt(LocalDateTime value);

    /**
     * Getter for <code>win_role_entry.delete_dt</code>.
     */
    public LocalDateTime getDeleteDt();

    /**
     * Setter for <code>win_role_entry.commit_id</code>.
     */
    public void setCommitId(Long value);

    /**
     * Getter for <code>win_role_entry.commit_id</code>.
     */
    public Long getCommitId();

    /**
     * Setter for <code>win_role_entry.name</code>.
     */
    public void setName(String value);

    /**
     * Getter for <code>win_role_entry.name</code>.
     */
    public String getName();

    /**
     * Setter for <code>win_role_entry.remark</code>.
     */
    public void setRemark(String value);

    /**
     * Getter for <code>win_role_entry.remark</code>.
     */
    public String getRemark();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common
     * interface IWinRoleEntry
     */
    public void from(IWinRoleEntry from);

    /**
     * Copy data into another generated Record/POJO implementing the common
     * interface IWinRoleEntry
     */
    public <E extends IWinRoleEntry> E into(E into);
}
