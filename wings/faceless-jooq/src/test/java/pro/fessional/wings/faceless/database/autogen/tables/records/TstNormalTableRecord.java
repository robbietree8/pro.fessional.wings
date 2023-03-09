/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.faceless.database.autogen.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record13;
import org.jooq.Row13;
import org.jooq.impl.UpdatableRecordImpl;
import pro.fessional.wings.faceless.database.autogen.tables.TstNormalTableTable;
import pro.fessional.wings.faceless.database.autogen.tables.interfaces.ITstNormalTable;
import pro.fessional.wings.faceless.database.autogen.tables.pojos.TstNormalTable;
import pro.fessional.wings.faceless.enums.autogen.StandardLanguage;

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
        "jOOQ version:3.17.8",
        "schema version:2020102701"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TstNormalTableRecord extends UpdatableRecordImpl<TstNormalTableRecord> implements Record13<Long, LocalDateTime, LocalDateTime, LocalDateTime, Long, String, BigDecimal, Boolean, Integer, Long, LocalDate, LocalTime, StandardLanguage>, ITstNormalTable {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>tst_normal_table.id</code>.
     */
    @Override
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>tst_normal_table.id</code>.
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>tst_normal_table.create_dt</code>.
     */
    @Override
    public void setCreateDt(LocalDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>tst_normal_table.create_dt</code>.
     */
    @Override
    public LocalDateTime getCreateDt() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>tst_normal_table.modify_dt</code>.
     */
    @Override
    public void setModifyDt(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>tst_normal_table.modify_dt</code>.
     */
    @Override
    public LocalDateTime getModifyDt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>tst_normal_table.delete_dt</code>.
     */
    @Override
    public void setDeleteDt(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>tst_normal_table.delete_dt</code>.
     */
    @Override
    public LocalDateTime getDeleteDt() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>tst_normal_table.commit_id</code>.
     */
    @Override
    public void setCommitId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>tst_normal_table.commit_id</code>.
     */
    @Override
    public Long getCommitId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>tst_normal_table.value_varchar</code>.
     */
    @Override
    public void setValueVarchar(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>tst_normal_table.value_varchar</code>.
     */
    @Override
    public String getValueVarchar() {
        return (String) get(5);
    }

    /**
     * Setter for <code>tst_normal_table.value_decimal</code>.
     */
    @Override
    public void setValueDecimal(BigDecimal value) {
        set(6, value);
    }

    /**
     * Getter for <code>tst_normal_table.value_decimal</code>.
     */
    @Override
    public BigDecimal getValueDecimal() {
        return (BigDecimal) get(6);
    }

    /**
     * Setter for <code>tst_normal_table.value_boolean</code>.
     */
    @Override
    public void setValueBoolean(Boolean value) {
        set(7, value);
    }

    /**
     * Getter for <code>tst_normal_table.value_boolean</code>.
     */
    @Override
    public Boolean getValueBoolean() {
        return (Boolean) get(7);
    }

    /**
     * Setter for <code>tst_normal_table.value_int</code>.
     */
    @Override
    public void setValueInt(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>tst_normal_table.value_int</code>.
     */
    @Override
    public Integer getValueInt() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>tst_normal_table.value_long</code>.
     */
    @Override
    public void setValueLong(Long value) {
        set(9, value);
    }

    /**
     * Getter for <code>tst_normal_table.value_long</code>.
     */
    @Override
    public Long getValueLong() {
        return (Long) get(9);
    }

    /**
     * Setter for <code>tst_normal_table.value_date</code>.
     */
    @Override
    public void setValueDate(LocalDate value) {
        set(10, value);
    }

    /**
     * Getter for <code>tst_normal_table.value_date</code>.
     */
    @Override
    public LocalDate getValueDate() {
        return (LocalDate) get(10);
    }

    /**
     * Setter for <code>tst_normal_table.value_time</code>.
     */
    @Override
    public void setValueTime(LocalTime value) {
        set(11, value);
    }

    /**
     * Getter for <code>tst_normal_table.value_time</code>.
     */
    @Override
    public LocalTime getValueTime() {
        return (LocalTime) get(11);
    }

    /**
     * Setter for <code>tst_normal_table.value_lang</code>.
     */
    @Override
    public void setValueLang(StandardLanguage value) {
        set(12, value);
    }

    /**
     * Getter for <code>tst_normal_table.value_lang</code>.
     */
    @Override
    public StandardLanguage getValueLang() {
        return (StandardLanguage) get(12);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record13 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row13<Long, LocalDateTime, LocalDateTime, LocalDateTime, Long, String, BigDecimal, Boolean, Integer, Long, LocalDate, LocalTime, StandardLanguage> fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    @Override
    public Row13<Long, LocalDateTime, LocalDateTime, LocalDateTime, Long, String, BigDecimal, Boolean, Integer, Long, LocalDate, LocalTime, StandardLanguage> valuesRow() {
        return (Row13) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return TstNormalTableTable.TstNormalTable.Id;
    }

    @Override
    public Field<LocalDateTime> field2() {
        return TstNormalTableTable.TstNormalTable.CreateDt;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return TstNormalTableTable.TstNormalTable.ModifyDt;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return TstNormalTableTable.TstNormalTable.DeleteDt;
    }

    @Override
    public Field<Long> field5() {
        return TstNormalTableTable.TstNormalTable.CommitId;
    }

    @Override
    public Field<String> field6() {
        return TstNormalTableTable.TstNormalTable.ValueVarchar;
    }

    @Override
    public Field<BigDecimal> field7() {
        return TstNormalTableTable.TstNormalTable.ValueDecimal;
    }

    @Override
    public Field<Boolean> field8() {
        return TstNormalTableTable.TstNormalTable.ValueBoolean;
    }

    @Override
    public Field<Integer> field9() {
        return TstNormalTableTable.TstNormalTable.ValueInt;
    }

    @Override
    public Field<Long> field10() {
        return TstNormalTableTable.TstNormalTable.ValueLong;
    }

    @Override
    public Field<LocalDate> field11() {
        return TstNormalTableTable.TstNormalTable.ValueDate;
    }

    @Override
    public Field<LocalTime> field12() {
        return TstNormalTableTable.TstNormalTable.ValueTime;
    }

    @Override
    public Field<StandardLanguage> field13() {
        return TstNormalTableTable.TstNormalTable.ValueLang;
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
        return getValueVarchar();
    }

    @Override
    public BigDecimal component7() {
        return getValueDecimal();
    }

    @Override
    public Boolean component8() {
        return getValueBoolean();
    }

    @Override
    public Integer component9() {
        return getValueInt();
    }

    @Override
    public Long component10() {
        return getValueLong();
    }

    @Override
    public LocalDate component11() {
        return getValueDate();
    }

    @Override
    public LocalTime component12() {
        return getValueTime();
    }

    @Override
    public StandardLanguage component13() {
        return getValueLang();
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
        return getValueVarchar();
    }

    @Override
    public BigDecimal value7() {
        return getValueDecimal();
    }

    @Override
    public Boolean value8() {
        return getValueBoolean();
    }

    @Override
    public Integer value9() {
        return getValueInt();
    }

    @Override
    public Long value10() {
        return getValueLong();
    }

    @Override
    public LocalDate value11() {
        return getValueDate();
    }

    @Override
    public LocalTime value12() {
        return getValueTime();
    }

    @Override
    public StandardLanguage value13() {
        return getValueLang();
    }

    @Override
    public TstNormalTableRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public TstNormalTableRecord value2(LocalDateTime value) {
        setCreateDt(value);
        return this;
    }

    @Override
    public TstNormalTableRecord value3(LocalDateTime value) {
        setModifyDt(value);
        return this;
    }

    @Override
    public TstNormalTableRecord value4(LocalDateTime value) {
        setDeleteDt(value);
        return this;
    }

    @Override
    public TstNormalTableRecord value5(Long value) {
        setCommitId(value);
        return this;
    }

    @Override
    public TstNormalTableRecord value6(String value) {
        setValueVarchar(value);
        return this;
    }

    @Override
    public TstNormalTableRecord value7(BigDecimal value) {
        setValueDecimal(value);
        return this;
    }

    @Override
    public TstNormalTableRecord value8(Boolean value) {
        setValueBoolean(value);
        return this;
    }

    @Override
    public TstNormalTableRecord value9(Integer value) {
        setValueInt(value);
        return this;
    }

    @Override
    public TstNormalTableRecord value10(Long value) {
        setValueLong(value);
        return this;
    }

    @Override
    public TstNormalTableRecord value11(LocalDate value) {
        setValueDate(value);
        return this;
    }

    @Override
    public TstNormalTableRecord value12(LocalTime value) {
        setValueTime(value);
        return this;
    }

    @Override
    public TstNormalTableRecord value13(StandardLanguage value) {
        setValueLang(value);
        return this;
    }

    @Override
    public TstNormalTableRecord values(Long value1, LocalDateTime value2, LocalDateTime value3, LocalDateTime value4, Long value5, String value6, BigDecimal value7, Boolean value8, Integer value9, Long value10, LocalDate value11, LocalTime value12, StandardLanguage value13) {
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
        return this;
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

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TstNormalTableRecord
     */
    public TstNormalTableRecord() {
        super(TstNormalTableTable.TstNormalTable);
    }

    /**
     * Create a detached, initialised TstNormalTableRecord
     */
    public TstNormalTableRecord(Long id, LocalDateTime createDt, LocalDateTime modifyDt, LocalDateTime deleteDt, Long commitId, String valueVarchar, BigDecimal valueDecimal, Boolean valueBoolean, Integer valueInt, Long valueLong, LocalDate valueDate, LocalTime valueTime, StandardLanguage valueLang) {
        super(TstNormalTableTable.TstNormalTable);

        setId(id);
        setCreateDt(createDt);
        setModifyDt(modifyDt);
        setDeleteDt(deleteDt);
        setCommitId(commitId);
        setValueVarchar(valueVarchar);
        setValueDecimal(valueDecimal);
        setValueBoolean(valueBoolean);
        setValueInt(valueInt);
        setValueLong(valueLong);
        setValueDate(valueDate);
        setValueTime(valueTime);
        setValueLang(valueLang);
    }

    /**
     * Create a detached, initialised TstNormalTableRecord
     */
    public TstNormalTableRecord(TstNormalTable value) {
        super(TstNormalTableTable.TstNormalTable);

        if (value != null) {
            setId(value.getId());
            setCreateDt(value.getCreateDt());
            setModifyDt(value.getModifyDt());
            setDeleteDt(value.getDeleteDt());
            setCommitId(value.getCommitId());
            setValueVarchar(value.getValueVarchar());
            setValueDecimal(value.getValueDecimal());
            setValueBoolean(value.getValueBoolean());
            setValueInt(value.getValueInt());
            setValueLong(value.getValueLong());
            setValueDate(value.getValueDate());
            setValueTime(value.getValueTime());
            setValueLang(value.getValueLang());
        }
    }
}
