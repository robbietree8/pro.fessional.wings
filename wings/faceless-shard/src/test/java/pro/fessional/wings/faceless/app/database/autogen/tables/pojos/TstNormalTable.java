/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.faceless.app.database.autogen.tables.pojos;


import pro.fessional.wings.faceless.app.database.autogen.tables.interfaces.ITstNormalTable;

import javax.annotation.processing.Generated;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


/**
 * The table <code>wings.tst_normal_table</code>.
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
public class TstNormalTable implements ITstNormalTable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDateTime createDt;
    private LocalDateTime modifyDt;
    private LocalDateTime deleteDt;
    private Long commitId;
    private String valueVarchar;
    private BigDecimal valueDecimal;
    private Boolean valueBoolean;
    private Integer valueInt;
    private Long valueLong;
    private LocalDate valueDate;
    private LocalTime valueTime;
    private Integer valueLang;

    public TstNormalTable() {}

    public TstNormalTable(ITstNormalTable value) {
        this.id = value.getId();
        this.createDt = value.getCreateDt();
        this.modifyDt = value.getModifyDt();
        this.deleteDt = value.getDeleteDt();
        this.commitId = value.getCommitId();
        this.valueVarchar = value.getValueVarchar();
        this.valueDecimal = value.getValueDecimal();
        this.valueBoolean = value.getValueBoolean();
        this.valueInt = value.getValueInt();
        this.valueLong = value.getValueLong();
        this.valueDate = value.getValueDate();
        this.valueTime = value.getValueTime();
        this.valueLang = value.getValueLang();
    }

    public TstNormalTable(
        Long id,
        LocalDateTime createDt,
        LocalDateTime modifyDt,
        LocalDateTime deleteDt,
        Long commitId,
        String valueVarchar,
        BigDecimal valueDecimal,
        Boolean valueBoolean,
        Integer valueInt,
        Long valueLong,
        LocalDate valueDate,
        LocalTime valueTime,
        Integer valueLang
    ) {
        this.id = id;
        this.createDt = createDt;
        this.modifyDt = modifyDt;
        this.deleteDt = deleteDt;
        this.commitId = commitId;
        this.valueVarchar = valueVarchar;
        this.valueDecimal = valueDecimal;
        this.valueBoolean = valueBoolean;
        this.valueInt = valueInt;
        this.valueLong = valueLong;
        this.valueDate = valueDate;
        this.valueTime = valueTime;
        this.valueLang = valueLang;
    }

    /**
     * Getter for <code>tst_normal_table.id</code>.
     */
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>tst_normal_table.id</code>.
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for <code>tst_normal_table.create_dt</code>.
     */
    @Override
    public LocalDateTime getCreateDt() {
        return this.createDt;
    }

    /**
     * Setter for <code>tst_normal_table.create_dt</code>.
     */
    @Override
    public void setCreateDt(LocalDateTime createDt) {
        this.createDt = createDt;
    }

    /**
     * Getter for <code>tst_normal_table.modify_dt</code>.
     */
    @Override
    public LocalDateTime getModifyDt() {
        return this.modifyDt;
    }

    /**
     * Setter for <code>tst_normal_table.modify_dt</code>.
     */
    @Override
    public void setModifyDt(LocalDateTime modifyDt) {
        this.modifyDt = modifyDt;
    }

    /**
     * Getter for <code>tst_normal_table.delete_dt</code>.
     */
    @Override
    public LocalDateTime getDeleteDt() {
        return this.deleteDt;
    }

    /**
     * Setter for <code>tst_normal_table.delete_dt</code>.
     */
    @Override
    public void setDeleteDt(LocalDateTime deleteDt) {
        this.deleteDt = deleteDt;
    }

    /**
     * Getter for <code>tst_normal_table.commit_id</code>.
     */
    @Override
    public Long getCommitId() {
        return this.commitId;
    }

    /**
     * Setter for <code>tst_normal_table.commit_id</code>.
     */
    @Override
    public void setCommitId(Long commitId) {
        this.commitId = commitId;
    }

    /**
     * Getter for <code>tst_normal_table.value_varchar</code>.
     */
    @Override
    public String getValueVarchar() {
        return this.valueVarchar;
    }

    /**
     * Setter for <code>tst_normal_table.value_varchar</code>.
     */
    @Override
    public void setValueVarchar(String valueVarchar) {
        this.valueVarchar = valueVarchar;
    }

    /**
     * Getter for <code>tst_normal_table.value_decimal</code>.
     */
    @Override
    public BigDecimal getValueDecimal() {
        return this.valueDecimal;
    }

    /**
     * Setter for <code>tst_normal_table.value_decimal</code>.
     */
    @Override
    public void setValueDecimal(BigDecimal valueDecimal) {
        this.valueDecimal = valueDecimal;
    }

    /**
     * Getter for <code>tst_normal_table.value_boolean</code>.
     */
    @Override
    public Boolean getValueBoolean() {
        return this.valueBoolean;
    }

    /**
     * Setter for <code>tst_normal_table.value_boolean</code>.
     */
    @Override
    public void setValueBoolean(Boolean valueBoolean) {
        this.valueBoolean = valueBoolean;
    }

    /**
     * Getter for <code>tst_normal_table.value_int</code>.
     */
    @Override
    public Integer getValueInt() {
        return this.valueInt;
    }

    /**
     * Setter for <code>tst_normal_table.value_int</code>.
     */
    @Override
    public void setValueInt(Integer valueInt) {
        this.valueInt = valueInt;
    }

    /**
     * Getter for <code>tst_normal_table.value_long</code>.
     */
    @Override
    public Long getValueLong() {
        return this.valueLong;
    }

    /**
     * Setter for <code>tst_normal_table.value_long</code>.
     */
    @Override
    public void setValueLong(Long valueLong) {
        this.valueLong = valueLong;
    }

    /**
     * Getter for <code>tst_normal_table.value_date</code>.
     */
    @Override
    public LocalDate getValueDate() {
        return this.valueDate;
    }

    /**
     * Setter for <code>tst_normal_table.value_date</code>.
     */
    @Override
    public void setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
    }

    /**
     * Getter for <code>tst_normal_table.value_time</code>.
     */
    @Override
    public LocalTime getValueTime() {
        return this.valueTime;
    }

    /**
     * Setter for <code>tst_normal_table.value_time</code>.
     */
    @Override
    public void setValueTime(LocalTime valueTime) {
        this.valueTime = valueTime;
    }

    /**
     * Getter for <code>tst_normal_table.value_lang</code>.
     */
    @Override
    public Integer getValueLang() {
        return this.valueLang;
    }

    /**
     * Setter for <code>tst_normal_table.value_lang</code>.
     */
    @Override
    public void setValueLang(Integer valueLang) {
        this.valueLang = valueLang;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final TstNormalTable other = (TstNormalTable) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.createDt == null) {
            if (other.createDt != null)
                return false;
        }
        else if (!this.createDt.equals(other.createDt))
            return false;
        if (this.modifyDt == null) {
            if (other.modifyDt != null)
                return false;
        }
        else if (!this.modifyDt.equals(other.modifyDt))
            return false;
        if (this.deleteDt == null) {
            if (other.deleteDt != null)
                return false;
        }
        else if (!this.deleteDt.equals(other.deleteDt))
            return false;
        if (this.commitId == null) {
            if (other.commitId != null)
                return false;
        }
        else if (!this.commitId.equals(other.commitId))
            return false;
        if (this.valueVarchar == null) {
            if (other.valueVarchar != null)
                return false;
        }
        else if (!this.valueVarchar.equals(other.valueVarchar))
            return false;
        if (this.valueDecimal == null) {
            if (other.valueDecimal != null)
                return false;
        }
        else if (!this.valueDecimal.equals(other.valueDecimal))
            return false;
        if (this.valueBoolean == null) {
            if (other.valueBoolean != null)
                return false;
        }
        else if (!this.valueBoolean.equals(other.valueBoolean))
            return false;
        if (this.valueInt == null) {
            if (other.valueInt != null)
                return false;
        }
        else if (!this.valueInt.equals(other.valueInt))
            return false;
        if (this.valueLong == null) {
            if (other.valueLong != null)
                return false;
        }
        else if (!this.valueLong.equals(other.valueLong))
            return false;
        if (this.valueDate == null) {
            if (other.valueDate != null)
                return false;
        }
        else if (!this.valueDate.equals(other.valueDate))
            return false;
        if (this.valueTime == null) {
            if (other.valueTime != null)
                return false;
        }
        else if (!this.valueTime.equals(other.valueTime))
            return false;
        if (this.valueLang == null) {
            if (other.valueLang != null)
                return false;
        }
        else if (!this.valueLang.equals(other.valueLang))
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
        result = prime * result + ((this.valueVarchar == null) ? 0 : this.valueVarchar.hashCode());
        result = prime * result + ((this.valueDecimal == null) ? 0 : this.valueDecimal.hashCode());
        result = prime * result + ((this.valueBoolean == null) ? 0 : this.valueBoolean.hashCode());
        result = prime * result + ((this.valueInt == null) ? 0 : this.valueInt.hashCode());
        result = prime * result + ((this.valueLong == null) ? 0 : this.valueLong.hashCode());
        result = prime * result + ((this.valueDate == null) ? 0 : this.valueDate.hashCode());
        result = prime * result + ((this.valueTime == null) ? 0 : this.valueTime.hashCode());
        result = prime * result + ((this.valueLang == null) ? 0 : this.valueLang.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TstNormalTable (");

        sb.append(id);
        sb.append(", ").append(createDt);
        sb.append(", ").append(modifyDt);
        sb.append(", ").append(deleteDt);
        sb.append(", ").append(commitId);
        sb.append(", ").append(valueVarchar);
        sb.append(", ").append(valueDecimal);
        sb.append(", ").append(valueBoolean);
        sb.append(", ").append(valueInt);
        sb.append(", ").append(valueLong);
        sb.append(", ").append(valueDate);
        sb.append(", ").append(valueTime);
        sb.append(", ").append(valueLang);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ITstNormalTable from) {
        setId(from.getId());
        setCreateDt(from.getCreateDt());
        setModifyDt(from.getModifyDt());
        setDeleteDt(from.getDeleteDt());
        setCommitId(from.getCommitId());
        setValueVarchar(from.getValueVarchar());
        setValueDecimal(from.getValueDecimal());
        setValueBoolean(from.getValueBoolean());
        setValueInt(from.getValueInt());
        setValueLong(from.getValueLong());
        setValueDate(from.getValueDate());
        setValueTime(from.getValueTime());
        setValueLang(from.getValueLang());
    }

    @Override
    public <E extends ITstNormalTable> E into(E into) {
        into.from(this);
        return into;
    }
}
