package pro.fessional.wings.faceless.flywave

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.MethodOrderer.MethodName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import pro.fessional.wings.faceless.WingsTestHelper
import pro.fessional.wings.faceless.WingsTestHelper.testcaseNotice
import pro.fessional.wings.faceless.flywave.SchemaFulldumpManager.Companion.groupedRegexp
import pro.fessional.wings.faceless.flywave.SchemaFulldumpManager.Companion.groupedTable
import pro.fessional.wings.faceless.util.FlywaveRevisionScanner
import java.io.File
import javax.sql.DataSource

/**
 * @author trydofor
 * @since 2019-06-20
 */

@SpringBootTest
@TestMethodOrder(MethodName::class)
@Disabled("导出表结构和数据，避免污染Git提交文件")
class SchemaFulldumpManagerTest {

    @Autowired
    lateinit var dataSource: DataSource

    @Autowired
    lateinit var schemaRevisionManager: SchemaRevisionManager

    @Autowired
    lateinit var schemaFulldumpManager: SchemaFulldumpManager

    val fold = "./src/test/resources/wings-flywave/fulldump"

    @Autowired
    lateinit var wingsTestHelper: WingsTestHelper

    @Test
    fun test0CleanTables() {
        wingsTestHelper.cleanTable()
        schemaRevisionManager.checkAndInitSql(FlywaveRevisionScanner.scanMaster(), 0, true)
    }

    @Test
    fun test1DumpDdlSeeFile() {
        File(fold).mkdirs()
        val dlls = schemaFulldumpManager.dumpDdl(dataSource, groupedRegexp(false,
                "SYS_LIGHT_SEQUENCE",
                "-- schema",
                "sys_schema_.*",
                "sys_commit_.*",
                "-- wings",
                "WG_.*"
        )
        )
        val file = "$fold/schema.sql"
        schemaFulldumpManager.saveFile(file, dlls)
        testcaseNotice("检查文件 $file")
    }

    @Test
    fun test2DumpRecSeeFile() {
        File(fold).mkdirs()
        val recs = schemaFulldumpManager.dumpRec(dataSource, groupedTable(true,
                "SYS_LIGHT_SEQUENCE",
                "-- schema",
                "sys_schema_journal",
                "sys_schema_version")
        )
        val file = "$fold/record.sql"
        schemaFulldumpManager.saveFile(file, recs)
        testcaseNotice("检查文件 $file")
    }
}
