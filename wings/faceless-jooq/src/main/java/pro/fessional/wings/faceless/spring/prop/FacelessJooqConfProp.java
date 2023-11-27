package pro.fessional.wings.faceless.spring.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * wings-jooq-conf-79.properties
 *
 * @author trydofor
 * @see #Key
 * @since 2021-02-13
 */
@Data
@ConfigurationProperties(FacelessJooqConfProp.Key)
public class FacelessJooqConfProp {

    public static final String Key = "wings.faceless.jooq.conf";

    /**
     * whether to enable jooq auto qualify.
     *
     * @see #Key$autoQualify
     */
    private String autoQualify = "";
    public static final String Key$autoQualify = Key + ".auto-qualify";


    /**
     * whether to use efficient mysql syntax when performing bulk inserts via Dao.
     *
     * @see #Key$batchMysql
     */
    private boolean batchMysql = true;
    public static final String Key$batchMysql = Key + ".batch-mysql";

    /**
     * whether to inject global converters, recommended in Table.
     *
     * @see #Key$converter
     */
    private boolean converter = false;
    public static final String Key$converter = Key + ".converter";

    /**
     * when deleting with commit_id, whether to update first and then delete.
     *
     * @see #Key$journalDelete
     */
    private String journalDelete = "";
    public static final String Key$journalDelete = Key + ".journal-delete";

    /**
     * whether to listen to table's create/update/delete.
     *
     * @see #Key$listenTableCud
     */
    private String listenTableCud = "";
    public static final String Key$listenTableCud = Key + ".listen-table-cud";

    /**
     * <pre>
     * whether the jOOQ `GROUP_CONCAT` function should be overflow-protected by setting
     * the `@@group_concat_max_len` session variable in MySQL style database
     *
     * MySQL truncates <`GROUP_CONCAT` results after a certain length, which may be way
     * too small for jOOQ's usage, especially when using the `MULTISET` emulation. By
     * default, jOOQ sets a session variable to the highest possible value prior to executing a
     * query containing `GROUP_CONCAT`. This flag can be used to opt out of this.
     *
     * - <a href="https://github.com/jOOQ/jOOQ/issues/12092">issues/12092</a>
     * - <a href="https://blog.jooq.org/mysqls-allowmultiqueries-flag-with-jdbc-and-jooq">mysqls-allowmultiqueries-flag-with-jdbc-and-jooq</a>
     * - <a href="https://www.jooq.org/doc/3.17/manual/sql-building/dsl-context/custom-settings/settings-group-concat">settings-group-concat</a>
     * </pre>
     *
     * @see #Key$renderGroupConcat
     */
    private boolean renderGroupConcat = false;
    public static final String Key$renderGroupConcat = Key + ".render-group-concat";

    /**
     * whether any catalog name should be rendered at all.
     * Use this for single-catalog environments, or when all objects are made
     * available using synonyms
     *
     * @see #Key$renderCatalog
     */
    private boolean renderCatalog = false;
    public static final String Key$renderCatalog = Key + ".render-catalog";

    /**
     * whether any schema name should be rendered at all.
     * Setting this to false also implicitly sets "renderCatalog" to false.
     * Use this for single-schema environments, or when all objects are made
     * available using synonyms
     *
     * @see #Key$renderSchema
     */
    private boolean renderSchema = false;
    public static final String Key$renderSchema = Key + ".render-schema";
}
