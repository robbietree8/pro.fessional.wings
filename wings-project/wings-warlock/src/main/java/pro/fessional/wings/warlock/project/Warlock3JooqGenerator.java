package pro.fessional.wings.warlock.project;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.jooq.meta.jaxb.Configuration;
import pro.fessional.wings.faceless.jooqgen.WingsCodeGenerator;
import pro.fessional.wings.faceless.jooqgen.WingsCodeGenerator.Builder;
import pro.fessional.wings.warlock.enums.autogen.GrantType;
import pro.fessional.wings.warlock.enums.autogen.UserGender;
import pro.fessional.wings.warlock.enums.autogen.UserStatus;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.function.Consumer;

/**
 * idea中，main函数执行和spring执行，workdir不同
 *
 * @author trydofor
 * @since 2021-02-20
 */
@Setter
@Getter
public class Warlock3JooqGenerator {

    private String targetDir = "./wings-warlock/src/main/java/";
    private String targetPkg = "pro.fessional.wings.warlock.database.autogen";
    private String configXml = "";

    @SneakyThrows
    @SafeVarargs
    public final void gen(String jdbc, String user, String pass, Consumer<Builder>... customize) {
        Configuration conf = null;
        if (configXml != null && !configXml.isEmpty()) {
            final InputStream ins;
            if (new File(configXml).isFile()) {
                ins = new FileInputStream(configXml);
            }
            else {
                ins = Warlock3JooqGenerator.class.getResourceAsStream(configXml);
            }
            if (ins != null) {
                conf = WingsCodeGenerator.config(ins);
            }
        }

        final Builder builder = WingsCodeGenerator
                .builder(conf)
                .jdbcDriver("com.mysql.cj.jdbc.Driver")
                .jdbcUrl(jdbc)
                .jdbcUser(user)
                .jdbcPassword(pass)
                .databaseVersionProvider("SELECT MAX(revision) FROM sys_schema_version WHERE apply_dt > '1000-01-01'")
                .targetPackage(targetPkg)
                .targetDirectory(targetDir)
                .forcedLocale(".*\\.locale")
                .forcedZoneId(".*\\.zoneid");

        for (Consumer<Builder> consumer : customize) {
            consumer.accept(builder);
        }
        builder.buildAndGenerate();
    }

    ///
    public static Consumer<Builder> includeWarlock() {
        return builder -> builder
                // 支持 pattern的注释写法
                .databaseIncludes(
                        "sys_constant_enum",
                        "sys_standard_i18n",
                        "win_.*"
                )
                .forcedIntConsEnum(UserGender.class, ".*\\.gender")
                .forcedIntConsEnum(UserStatus.class, "win_user_basis\\.status")
                .forcedIntConsEnum(GrantType.class, "win_.*_grant\\.grant_type")
                ;
    }
}
