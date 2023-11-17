/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.faceless.database.autogen;


import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;
import pro.fessional.wings.faceless.database.autogen.tables.SysConstantEnumTable;
import pro.fessional.wings.faceless.database.autogen.tables.SysStandardI18nTable;
import pro.fessional.wings.faceless.database.autogen.tables.TstNormalTableTable;
import pro.fessional.wings.faceless.database.autogen.tables.TstShardingTable;

import javax.annotation.processing.Generated;
import java.util.Arrays;
import java.util.List;


/**
 * The schema <code>wings</code>.
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
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>DEFAULT_SCHEMA</code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * The table <code>sys_constant_enum</code>.
     */
    public final SysConstantEnumTable SysConstantEnum = SysConstantEnumTable.SysConstantEnum;

    /**
     * The table <code>sys_standard_i18n</code>.
     */
    public final SysStandardI18nTable SysStandardI18n = SysStandardI18nTable.SysStandardI18n;

    /**
     * The table <code>tst_normal_table</code>.
     */
    public final TstNormalTableTable TstNormalTable = TstNormalTableTable.TstNormalTable;

    /**
     * The table <code>tst_sharding</code>.
     */
    public final TstShardingTable TstSharding = TstShardingTable.TstSharding;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            SysConstantEnumTable.SysConstantEnum,
            SysStandardI18nTable.SysStandardI18n,
            TstNormalTableTable.TstNormalTable,
            TstShardingTable.TstSharding
        );
    }
}
