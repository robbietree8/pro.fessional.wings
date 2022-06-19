package pro.fessional.wings.warlock.project;

import lombok.Getter;
import pro.fessional.wings.faceless.flywave.SchemaRevisionManager;
import pro.fessional.wings.faceless.flywave.WingsRevision;
import pro.fessional.wings.faceless.util.FlywaveInteractiveGui;
import pro.fessional.wings.faceless.util.FlywaveRevisionScanner;
import pro.fessional.wings.faceless.util.FlywaveRevisionScanner.Helper;

import java.util.Arrays;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeSet;
import java.util.function.Consumer;

/**
 * 按常见的版本管理场景提供便捷方式。
 * <p>
 * spring.wings.faceless.flywave.enabled.module=true
 *
 * @author trydofor
 * @since 2021-02-20
 */
@Getter
public class Warlock1SchemaManager {

    public static final long InitRevision = 2020_10_24_02;
    protected final SchemaRevisionManager schemaRevisionManager;

    public Warlock1SchemaManager(SchemaRevisionManager schemaRevisionManager) {
        this(schemaRevisionManager, true);
    }

    public Warlock1SchemaManager(SchemaRevisionManager schemaRevisionManager, boolean enableGui) {
        this.schemaRevisionManager = schemaRevisionManager;
        if (enableGui) {
            schemaRevisionManager.askWay(FlywaveInteractiveGui.askGui());
            schemaRevisionManager.logWay(FlywaveInteractiveGui.logGui());
        }
    }

    /**
     * 适用于项目的线性升级，初始化warlock及项目第一版，以时间戳负值作为commitId，表示手动执行。
     *
     * @param revi      publish的目标版本
     * @param customize 路径helper
     */
    @SafeVarargs
    public final void mergePublish(long revi, Consumer<Helper>... customize) {
        final Helper helper = FlywaveRevisionScanner.helper();
        for (Consumer<Helper> consumer : customize) {
            consumer.accept(helper);
        }
        mergePublish(helper.scan(), -System.currentTimeMillis(), revi);
    }

    /**
     * 适用于线性的升级或降级。①checkAndInitSql合并(插入或更新)脚本；②publishRevision到指定版本。
     * 注意：若降级且降级脚本被更新，可能导致降级失败，此时应该使用 forceDownThenMergePub
     *
     * @param sqls     revi脚本
     * @param commitId cid
     * @param revision 目标版本
     */
    public void mergePublish(SortedMap<Long, SchemaRevisionManager.RevisionSql> sqls, long commitId, long revision) {
        schemaRevisionManager.checkAndInitSql(sqls, commitId, true);
        schemaRevisionManager.publishRevision(revision, commitId);
    }

    /**
     * 适用于断点发布，先合并脚本，然后发布未apply的合并进来的版本。
     * ①checkAndInitSql合并脚本；②forceApplyBreak合并进来的脚本。
     *
     * @param sqls     脚本
     * @param commitId cid
     */
    public void mergeForceApply(SortedMap<Long, SchemaRevisionManager.RevisionSql> sqls, long commitId, boolean isUpto) {
        schemaRevisionManager.checkAndInitSql(sqls, commitId, true);
        for (Long rev : sqls.keySet()) {
            schemaRevisionManager.forceApplyBreak(rev, commitId, isUpto, null);
        }
    }


    /**
     * 适用于降级脚本变化的重新发布，先排序版本，强制倒序降级，合并脚本，正序升级版本。
     * ①forceApplyBreak降级脚本；②checkAndInitSql合并；③publishRevision到指定版本
     *
     * @param sqls     脚本
     * @param commitId cid
     * @param revision 目标版本
     */
    public void downThenMergePublish(SortedMap<Long, SchemaRevisionManager.RevisionSql> sqls, long commitId, Collection<Long> revision) {
        final TreeSet<Long> tree = new TreeSet<>(revision);
        for (Long rev : tree.descendingSet()) {
            schemaRevisionManager.forceApplyBreak(rev, commitId, false, null);
        }
        schemaRevisionManager.checkAndInitSql(sqls, commitId, true);
        for (long rev : tree) {
            schemaRevisionManager.publishRevision(rev, commitId);
        }
    }

    public void downThenMergePublish(SortedMap<Long, SchemaRevisionManager.RevisionSql> sqls, long commitId, Long... revision) {
        downThenMergePublish(sqls, commitId, Arrays.asList(revision));
    }

    ///
    public static Consumer<Helper> includeWarlockPath() {
        return helper -> helper.path(
                WingsRevision.V00_19_0512_01_Schema,
                WingsRevision.V01_19_0520_01_IdLog,
                WingsRevision.V01_19_0521_01_EnumI18n,
                WingsRevision.V04_20_1024_01_UserLogin,
                WingsRevision.V04_20_1024_02_RolePermit,
                WingsRevision.V05_20_1025_01_ConfRuntime
        );
    }

    public static Consumer<Helper> includeWarlockRevi() {
        return helper -> {
            helper.include(WingsRevision.V00_19_0512_01_Schema);
            helper.include(WingsRevision.V01_19_0520_01_IdLog);
            helper.include(WingsRevision.V01_19_0521_01_EnumI18n);
            helper.include(WingsRevision.V04_20_1024_01_UserLogin);
            helper.include(WingsRevision.V04_20_1024_02_RolePermit);
            helper.include(WingsRevision.V05_20_1025_01_ConfRuntime);
        };
    }
}