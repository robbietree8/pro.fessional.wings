/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.warlock.database.autogen.tables.interfaces;


import pro.fessional.wings.faceless.service.journal.JournalAware;
import pro.fessional.wings.warlock.enums.autogen.GrantType;

import javax.annotation.processing.Generated;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * The table <code>wings.win_role_grant</code>.
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
public interface IWinRoleGrant extends JournalAware, Serializable {

    /**
     * Setter for <code>win_role_grant.refer_role</code>.
     */
    public void setReferRole(Long value);

    /**
     * Getter for <code>win_role_grant.refer_role</code>.
     */
    public Long getReferRole();

    /**
     * Setter for <code>win_role_grant.grant_type</code>.
     */
    public void setGrantType(GrantType value);

    /**
     * Getter for <code>win_role_grant.grant_type</code>.
     */
    public GrantType getGrantType();

    /**
     * Setter for <code>win_role_grant.grant_entry</code>.
     */
    public void setGrantEntry(Long value);

    /**
     * Getter for <code>win_role_grant.grant_entry</code>.
     */
    public Long getGrantEntry();

    /**
     * Setter for <code>win_role_grant.create_dt</code>.
     */
    public void setCreateDt(LocalDateTime value);

    /**
     * Getter for <code>win_role_grant.create_dt</code>.
     */
    public LocalDateTime getCreateDt();

    /**
     * Setter for <code>win_role_grant.commit_id</code>.
     */
    public void setCommitId(Long value);

    /**
     * Getter for <code>win_role_grant.commit_id</code>.
     */
    public Long getCommitId();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common
     * interface IWinRoleGrant
     */
    public void from(IWinRoleGrant from);

    /**
     * Copy data into another generated Record/POJO implementing the common
     * interface IWinRoleGrant
     */
    public <E extends IWinRoleGrant> E into(E into);
}
