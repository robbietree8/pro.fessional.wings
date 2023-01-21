/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.faceless.database.autogen.tables.pojos;


import pro.fessional.wings.faceless.database.autogen.tables.interfaces.ITst中文也分表;
import pro.fessional.wings.faceless.enums.autogen.StandardLanguage;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;


/**
 * The table <code>wings_test.tst_中文也分表</code>.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.16",
        "schema version:2019060102"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tst中文也分表 implements ITst中文也分表 {

    private static final long serialVersionUID = 1L;

    private Long             id;
    private LocalDateTime    createDt;
    private LocalDateTime    modifyDt;
    private LocalDateTime    deleteDt;
    private Long             commitId;
    private String           loginInfo;
    private String           otherInfo;
    private StandardLanguage language;

    public Tst中文也分表() {}

    public Tst中文也分表(ITst中文也分表 value) {
        this.id = value.getId();
        this.createDt = value.getCreateDt();
        this.modifyDt = value.getModifyDt();
        this.deleteDt = value.getDeleteDt();
        this.commitId = value.getCommitId();
        this.loginInfo = value.getLoginInfo();
        this.otherInfo = value.getOtherInfo();
        this.language = value.getLanguage();
    }

    public Tst中文也分表(
        Long             id,
        LocalDateTime    createDt,
        LocalDateTime    modifyDt,
        LocalDateTime    deleteDt,
        Long             commitId,
        String           loginInfo,
        String           otherInfo,
        StandardLanguage language
    ) {
        this.id = id;
        this.createDt = createDt;
        this.modifyDt = modifyDt;
        this.deleteDt = deleteDt;
        this.commitId = commitId;
        this.loginInfo = loginInfo;
        this.otherInfo = otherInfo;
        this.language = language;
    }

    /**
     * Getter for <code>tst_中文也分表.id</code>.
     */
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>tst_中文也分表.id</code>.
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for <code>tst_中文也分表.create_dt</code>.
     */
    @Override
    public LocalDateTime getCreateDt() {
        return this.createDt;
    }

    /**
     * Setter for <code>tst_中文也分表.create_dt</code>.
     */
    @Override
    public void setCreateDt(LocalDateTime createDt) {
        this.createDt = createDt;
    }

    /**
     * Getter for <code>tst_中文也分表.modify_dt</code>.
     */
    @Override
    public LocalDateTime getModifyDt() {
        return this.modifyDt;
    }

    /**
     * Setter for <code>tst_中文也分表.modify_dt</code>.
     */
    @Override
    public void setModifyDt(LocalDateTime modifyDt) {
        this.modifyDt = modifyDt;
    }

    /**
     * Getter for <code>tst_中文也分表.delete_dt</code>.
     */
    @Override
    public LocalDateTime getDeleteDt() {
        return this.deleteDt;
    }

    /**
     * Setter for <code>tst_中文也分表.delete_dt</code>.
     */
    @Override
    public void setDeleteDt(LocalDateTime deleteDt) {
        this.deleteDt = deleteDt;
    }

    /**
     * Getter for <code>tst_中文也分表.commit_id</code>.
     */
    @Override
    public Long getCommitId() {
        return this.commitId;
    }

    /**
     * Setter for <code>tst_中文也分表.commit_id</code>.
     */
    @Override
    public void setCommitId(Long commitId) {
        this.commitId = commitId;
    }

    /**
     * Getter for <code>tst_中文也分表.login_info</code>.
     */
    @Override
    public String getLoginInfo() {
        return this.loginInfo;
    }

    /**
     * Setter for <code>tst_中文也分表.login_info</code>.
     */
    @Override
    public void setLoginInfo(String loginInfo) {
        this.loginInfo = loginInfo;
    }

    /**
     * Getter for <code>tst_中文也分表.other_info</code>.
     */
    @Override
    public String getOtherInfo() {
        return this.otherInfo;
    }

    /**
     * Setter for <code>tst_中文也分表.other_info</code>.
     */
    @Override
    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    /**
     * Getter for <code>tst_中文也分表.language</code>.
     */
    @Override
    public StandardLanguage getLanguage() {
        return this.language;
    }

    /**
     * Setter for <code>tst_中文也分表.language</code>.
     */
    @Override
    public void setLanguage(StandardLanguage language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Tst中文也分表 other = (Tst中文也分表) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        if (createDt == null) {
            if (other.createDt != null)
                return false;
        }
        else if (!createDt.equals(other.createDt))
            return false;
        if (modifyDt == null) {
            if (other.modifyDt != null)
                return false;
        }
        else if (!modifyDt.equals(other.modifyDt))
            return false;
        if (deleteDt == null) {
            if (other.deleteDt != null)
                return false;
        }
        else if (!deleteDt.equals(other.deleteDt))
            return false;
        if (commitId == null) {
            if (other.commitId != null)
                return false;
        }
        else if (!commitId.equals(other.commitId))
            return false;
        if (loginInfo == null) {
            if (other.loginInfo != null)
                return false;
        }
        else if (!loginInfo.equals(other.loginInfo))
            return false;
        if (otherInfo == null) {
            if (other.otherInfo != null)
                return false;
        }
        else if (!otherInfo.equals(other.otherInfo))
            return false;
        if (language == null) {
            if (other.language != null)
                return false;
        }
        else if (!language.equals(other.language))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.createDt == null) ? 0 : this.createDt.hashCode());
        result = prime * result + ((this.modifyDt == null) ? 0 : this.modifyDt.hashCode());
        result = prime * result + ((this.deleteDt == null) ? 0 : this.deleteDt.hashCode());
        result = prime * result + ((this.commitId == null) ? 0 : this.commitId.hashCode());
        result = prime * result + ((this.loginInfo == null) ? 0 : this.loginInfo.hashCode());
        result = prime * result + ((this.otherInfo == null) ? 0 : this.otherInfo.hashCode());
        result = prime * result + ((this.language == null) ? 0 : this.language.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Tst中文也分表 (");

        sb.append(id);
        sb.append(", ").append(createDt);
        sb.append(", ").append(modifyDt);
        sb.append(", ").append(deleteDt);
        sb.append(", ").append(commitId);
        sb.append(", ").append(loginInfo);
        sb.append(", ").append(otherInfo);
        sb.append(", ").append(language);

        sb.append(")");
        return sb.toString();
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
}
