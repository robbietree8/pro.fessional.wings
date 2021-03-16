/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.warlock.database.autogen.tables.daos;


import org.jooq.Configuration;
import org.jooq.Record2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pro.fessional.wings.faceless.database.jooq.WingsJooqDaoImpl;
import pro.fessional.wings.warlock.database.autogen.tables.WinUserRoleMapTable;
import pro.fessional.wings.warlock.database.autogen.tables.pojos.WinUserRoleMap;
import pro.fessional.wings.warlock.database.autogen.tables.records.WinUserRoleMapRecord;

import javax.annotation.Generated;
import java.time.LocalDateTime;
import java.util.List;


/**
 * The table <code>wings_warlock.win_user_role_map</code>.
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
public class WinUserRoleMapDao extends WingsJooqDaoImpl<WinUserRoleMapTable, WinUserRoleMapRecord, WinUserRoleMap, Record2<Long, Long>> {

    /**
     * Create a new WinUserRoleMapDao without any configuration
     */
    public WinUserRoleMapDao() {
        super(WinUserRoleMapTable.WinUserRoleMap, WinUserRoleMap.class);
    }

    /**
     * Create a new WinUserRoleMapDao with an attached configuration
     */
    @Autowired
    public WinUserRoleMapDao(Configuration configuration) {
        super(WinUserRoleMapTable.WinUserRoleMap, WinUserRoleMap.class, configuration);
    }

    @Override
    public Record2<Long, Long> getId(WinUserRoleMap object) {
        return compositeKeyRecord(object.getReferUser(), object.getGrantRole());
    }

    /**
     * Fetch records that have <code>refer_user BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserRoleMap> fetchRangeOfReferUser(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(WinUserRoleMapTable.WinUserRoleMap.ReferUser, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>refer_user IN (values)</code>
     */
    public List<WinUserRoleMap> fetchByReferUser(Long... values) {
        return fetch(WinUserRoleMapTable.WinUserRoleMap.ReferUser, values);
    }

    /**
     * Fetch records that have <code>grant_role BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserRoleMap> fetchRangeOfGrantRole(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(WinUserRoleMapTable.WinUserRoleMap.GrantRole, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>grant_role IN (values)</code>
     */
    public List<WinUserRoleMap> fetchByGrantRole(Long... values) {
        return fetch(WinUserRoleMapTable.WinUserRoleMap.GrantRole, values);
    }

    /**
     * Fetch records that have <code>create_dt BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserRoleMap> fetchRangeOfCreateDt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(WinUserRoleMapTable.WinUserRoleMap.CreateDt, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>create_dt IN (values)</code>
     */
    public List<WinUserRoleMap> fetchByCreateDt(LocalDateTime... values) {
        return fetch(WinUserRoleMapTable.WinUserRoleMap.CreateDt, values);
    }

    /**
     * Fetch records that have <code>modify_dt BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserRoleMap> fetchRangeOfModifyDt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(WinUserRoleMapTable.WinUserRoleMap.ModifyDt, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>modify_dt IN (values)</code>
     */
    public List<WinUserRoleMap> fetchByModifyDt(LocalDateTime... values) {
        return fetch(WinUserRoleMapTable.WinUserRoleMap.ModifyDt, values);
    }

    /**
     * Fetch records that have <code>delete_dt BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserRoleMap> fetchRangeOfDeleteDt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(WinUserRoleMapTable.WinUserRoleMap.DeleteDt, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>delete_dt IN (values)</code>
     */
    public List<WinUserRoleMap> fetchByDeleteDt(LocalDateTime... values) {
        return fetch(WinUserRoleMapTable.WinUserRoleMap.DeleteDt, values);
    }

    /**
     * Fetch records that have <code>commit_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<WinUserRoleMap> fetchRangeOfCommitId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(WinUserRoleMapTable.WinUserRoleMap.CommitId, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>commit_id IN (values)</code>
     */
    public List<WinUserRoleMap> fetchByCommitId(Long... values) {
        return fetch(WinUserRoleMapTable.WinUserRoleMap.CommitId, values);
    }
}