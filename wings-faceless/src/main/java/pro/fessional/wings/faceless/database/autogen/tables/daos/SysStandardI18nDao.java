/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.faceless.database.autogen.tables.daos;


import org.jooq.Configuration;
import org.jooq.Record4;
import pro.fessional.wings.faceless.database.autogen.tables.SysStandardI18nTable;
import pro.fessional.wings.faceless.database.autogen.tables.pojos.SysStandardI18n;
import pro.fessional.wings.faceless.database.autogen.tables.records.SysStandardI18nRecord;
import pro.fessional.wings.faceless.database.common.WingsJooqDaoImpl;

import javax.annotation.Generated;
import java.util.List;


/**
 * The table <code>wings.sys_standard_i18n</code>.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4",
        "schema version:2019052101"
    },
    date = "2020-06-14T04:56:04.482Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysStandardI18nDao extends WingsJooqDaoImpl<SysStandardI18nTable, SysStandardI18nRecord, SysStandardI18n, Record4<String, String, String, String>> {

    /**
     * Create a new SysStandardI18nDao without any configuration
     */
    public SysStandardI18nDao() {
        super(SysStandardI18nTable.SysStandardI18n, SysStandardI18nTable.asM5, SysStandardI18n.class);
    }

    /**
     * Create a new SysStandardI18nDao with an attached configuration
     */
    public SysStandardI18nDao(Configuration configuration) {
        super(SysStandardI18nTable.SysStandardI18n, SysStandardI18nTable.asM5, SysStandardI18n.class, configuration);
    }

    @Override
    public Record4<String, String, String, String> getId(SysStandardI18n object) {
        return compositeKeyRecord(object.getBase(), object.getKind(), object.getUkey(), object.getLang());
    }

    /**
     * Fetch records that have <code>base IN (values)</code>
     */
    public List<SysStandardI18n> fetchByBase(String... values) {
        return fetch(SysStandardI18nTable.asM5.Base, values);
    }

    /**
     * Fetch records that have <code>kind IN (values)</code>
     */
    public List<SysStandardI18n> fetchByKind(String... values) {
        return fetch(SysStandardI18nTable.asM5.Kind, values);
    }

    /**
     * Fetch records that have <code>ukey IN (values)</code>
     */
    public List<SysStandardI18n> fetchByUkey(String... values) {
        return fetch(SysStandardI18nTable.asM5.Ukey, values);
    }

    /**
     * Fetch records that have <code>lang IN (values)</code>
     */
    public List<SysStandardI18n> fetchByLang(String... values) {
        return fetch(SysStandardI18nTable.asM5.Lang, values);
    }

    /**
     * Fetch records that have <code>text IN (values)</code>
     */
    public List<SysStandardI18n> fetchByText(String... values) {
        return fetch(SysStandardI18nTable.asM5.Text, values);
    }
}
