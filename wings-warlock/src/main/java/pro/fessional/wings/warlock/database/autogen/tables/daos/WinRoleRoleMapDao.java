/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.warlock.database.autogen.tables.daos;


import org.jooq.Configuration;
import org.jooq.Record2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pro.fessional.wings.faceless.database.jooq.WingsJooqDaoImpl;
import pro.fessional.wings.warlock.database.autogen.tables.WinRoleRoleMapTable;
import pro.fessional.wings.warlock.database.autogen.tables.pojos.WinRoleRoleMap;
import pro.fessional.wings.warlock.database.autogen.tables.records.WinRoleRoleMapRecord;

import javax.annotation.Generated;
import java.time.LocalDateTime;
import java.util.List;


/**
 * The table <code>wings_warlock.win_role_role_map</code>.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4",
        "schema version:2020102402"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class WinRoleRoleMapDao extends WingsJooqDaoImpl<WinRoleRoleMapTable, WinRoleRoleMapRecord, WinRoleRoleMap, Record2<Long, Long>> {

    /**
     * Create a new WinRoleRoleMapDao without any configuration
     */
    public WinRoleRoleMapDao() {
        super(WinRoleRoleMapTable.WinRoleRoleMap, WinRoleRoleMap.class);
    }

    /**
     * Create a new WinRoleRoleMapDao with an attached configuration
     */
    @Autowired
    public WinRoleRoleMapDao(Configuration configuration) {
        super(WinRoleRoleMapTable.WinRoleRoleMap, WinRoleRoleMap.class, configuration);
    }

    @Override
    public Record2<Long, Long> getId(WinRoleRoleMap object) {
        return compositeKeyRecord(object.getReferRole(), object.getGrantRole());
    }

    /**
     * Fetch records that have <code>refer_role BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinRoleRoleMap> fetchRangeOfReferRole(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(WinRoleRoleMapTable.WinRoleRoleMap.ReferRole, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>refer_role IN (values)</code>
     */
    public List<WinRoleRoleMap> fetchByReferRole(Long... values) {
        return fetch(WinRoleRoleMapTable.WinRoleRoleMap.ReferRole, values);
    }

    /**
     * Fetch records that have <code>grant_role BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinRoleRoleMap> fetchRangeOfGrantRole(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(WinRoleRoleMapTable.WinRoleRoleMap.GrantRole, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>grant_role IN (values)</code>
     */
    public List<WinRoleRoleMap> fetchByGrantRole(Long... values) {
        return fetch(WinRoleRoleMapTable.WinRoleRoleMap.GrantRole, values);
    }

    /**
     * Fetch records that have <code>create_dt BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinRoleRoleMap> fetchRangeOfCreateDt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(WinRoleRoleMapTable.WinRoleRoleMap.CreateDt, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>create_dt IN (values)</code>
     */
    public List<WinRoleRoleMap> fetchByCreateDt(LocalDateTime... values) {
        return fetch(WinRoleRoleMapTable.WinRoleRoleMap.CreateDt, values);
    }

    /**
     * Fetch records that have <code>modify_dt BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinRoleRoleMap> fetchRangeOfModifyDt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(WinRoleRoleMapTable.WinRoleRoleMap.ModifyDt, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>modify_dt IN (values)</code>
     */
    public List<WinRoleRoleMap> fetchByModifyDt(LocalDateTime... values) {
        return fetch(WinRoleRoleMapTable.WinRoleRoleMap.ModifyDt, values);
    }

    /**
     * Fetch records that have <code>delete_dt BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinRoleRoleMap> fetchRangeOfDeleteDt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(WinRoleRoleMapTable.WinRoleRoleMap.DeleteDt, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>delete_dt IN (values)</code>
     */
    public List<WinRoleRoleMap> fetchByDeleteDt(LocalDateTime... values) {
        return fetch(WinRoleRoleMapTable.WinRoleRoleMap.DeleteDt, values);
    }

    /**
     * Fetch records that have <code>commit_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinRoleRoleMap> fetchRangeOfCommitId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(WinRoleRoleMapTable.WinRoleRoleMap.CommitId, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>commit_id IN (values)</code>
     */
    public List<WinRoleRoleMap> fetchByCommitId(Long... values) {
        return fetch(WinRoleRoleMapTable.WinRoleRoleMap.CommitId, values);
    }
}