package pro.fessional.wings.warlock.service.perm.impl;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.jooq.Record3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pro.fessional.wings.faceless.service.journal.JournalService;
import pro.fessional.wings.faceless.service.lightid.LightIdService;
import pro.fessional.wings.warlock.database.autogen.tables.WinPermEntryTable;
import pro.fessional.wings.warlock.database.autogen.tables.daos.WinPermEntryDao;
import pro.fessional.wings.warlock.database.autogen.tables.pojos.WinPermEntry;
import pro.fessional.wings.warlock.event.cache.TableChangeEvent;
import pro.fessional.wings.warlock.service.perm.WarlockPermService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static pro.fessional.wings.warlock.service.grant.PermGrantHelper.unitePermit;
import static pro.fessional.wings.warlock.service.perm.impl.WarlockPermCacheConst.KeyPermAll;

/**
 * @author trydofor
 * @since 2021-03-07
 */
@Service
@Slf4j
@CacheConfig(cacheNames = WarlockPermCacheConst.CacheName, cacheManager = WarlockPermCacheConst.ManagerName)
public class WarlockPermServiceImpl implements WarlockPermService {

    @Setter(onMethod_ = {@Autowired})
    private WinPermEntryDao winPermEntryDao;

    @Setter(onMethod_ = {@Autowired})
    private LightIdService lightIdService;
    @Setter(onMethod_ = {@Autowired})
    private JournalService journalService;

    @Override
    @Cacheable(key = KeyPermAll)
    public Map<Long, String> loadPermAll() {
        final WinPermEntryTable t = winPermEntryDao.getTable();

        final Map<Long, String> all = winPermEntryDao
                .ctx()
                .select(t.Id, t.Scopes, t.Action)
                .from(t)
                .where(t.onlyLiveData)
                .fetch()
                .intoMap(Record3::value1, it -> unitePermit(it.value2(), it.value3()));
        log.info("loadPermAll size={}", all.size());
        return all;
    }

    /**
     * 异步清理缓存，event可以为null
     * @param event 可以为null
     */
    @Async
    @EventListener
    @CacheEvict(key = KeyPermAll)
    public void evictPermAllCache(TableChangeEvent event) {
        if (event == null) {
            log.info("evict cache={} by NULL", KeyPermAll);
        }
        else if (WinPermEntryTable.WinPermEntry.getName().equalsIgnoreCase(event.getTable())) {
            log.info("evict cache={} by TableChangeEvent", KeyPermAll);
        }
    }

    @Override
    public void create(@NotNull String scopes, @NotNull Collection<Act> acts) {
        if (acts.isEmpty()) return;

        journalService.commit(Jane.Create, scopes, commit -> {
            List<WinPermEntry> pos = new ArrayList<>(acts.size());
            final WinPermEntryTable t = winPermEntryDao.getTable();
            for (Act act : acts) {
                WinPermEntry po = new WinPermEntry();
                po.setId(lightIdService.getId(t));
                po.setScopes(scopes);
                po.setAction(act.getAction());
                po.setRemark(act.getRemark());
                commit.create(po);
                pos.add(po);
            }
            log.info("insert perm scope={}, action count={}", scopes, acts.size());
            winPermEntryDao.insert(pos);
        });
    }

    @Override
    public void modify(long permId, @NotNull String remark) {
        journalService.commit(Jane.Modify, permId, commit -> {
            final WinPermEntryTable t = winPermEntryDao.getTable();
            final int rc = winPermEntryDao
                    .ctx()
                    .update(t)
                    .set(t.CommitId, commit.getCommitId())
                    .set(t.ModifyDt, commit.getCommitDt())
                    .set(t.Remark, remark)
                    .where(t.Id.eq(permId))
                    .execute();
            log.info("modify perm remark. permId={}, affect={}", permId, rc);
        });
    }
}
