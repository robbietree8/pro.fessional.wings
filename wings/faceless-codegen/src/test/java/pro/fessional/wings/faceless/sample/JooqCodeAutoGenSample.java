package pro.fessional.wings.faceless.sample;

import pro.fessional.wings.faceless.enums.autogen.StandardLanguage;
import pro.fessional.wings.faceless.jooqgen.WingsCodeGenerator;

/**
 * FacelessAutogenTest instead
 *
 * @author trydofor
 * @since 2019-05-31
 */
public class JooqCodeAutoGenSample {

    /**
     * Pay attention to the path, should be the project top-level directory.
     * Note that in the target project, you should comment out `.springRepository(false)` to auto load the `Dao`
     */
    public static void main(String[] args) {
        // === Must Drop And Init ===
        // WingsJooqDaoAliasImplTest#test0DropAndInit

        genJooq();
        genShard();
    }

    private static final String database = "wings_faceless";
    private static final String user = "trydofor";
    private static final String pass = "moilioncircle";

    private static void genJooq() {
        WingsCodeGenerator.builder()
                          .jdbcDriver("com.mysql.cj.jdbc.Driver")
                          .jdbcUrl("jdbc:mysql://localhost/" + database)
                          .jdbcUser(user)
                          .jdbcPassword(pass)
                          .databaseSchema(database)
                          // support Regexp comment
                          .databaseIncludes("sys_constant_enum" +
                                            "|sys_standard_i18n" +
                                            "|tst_sharding")
                          .databaseVersionProvider("SELECT MAX(revision) FROM sys_schema_version WHERE apply_dt > '1000-01-01'")
                          .targetPackage("pro.fessional.wings.faceless.database.autogen")
                          .targetDirectory("wings/faceless-jooq/src/test/java/")
//  Disable spring auto scan
//                          .springRepository(false)
//  use enum type
//                          .forcedType(new ForcedType()
//                                  .withUserType("pro.fessional.wings.faceless.enums.auto.StandardLanguage")
//                                  .withConverter("pro.fessional.wings.faceless.database.jooq.converter.JooqConsEnumConverter.of(StandardLanguage.class)")
//                                  .withExpression("tst_sharding.language")
//                          )
                          .forcedIntConsEnum(StandardLanguage.class, "tst_sharding.language")
                          .buildAndGenerate();
    }

    private static void genShard() {
        WingsCodeGenerator.builder()
                          .jdbcDriver("com.mysql.cj.jdbc.Driver")
                          .jdbcUrl("jdbc:mysql://localhost/" + database)
                          .jdbcUser(user)
                          .jdbcPassword(pass)
                          .databaseSchema(database)
                          // support Regexp comment
                          .databaseIncludes("tst_sharding")
                          .databaseVersionProvider(null)
                          .targetPackage("pro.fessional.wings.faceless.database.autogen")
                          .targetDirectory("wings/faceless-shard/src/test/java/")
                          .buildAndGenerate();
    }
}
