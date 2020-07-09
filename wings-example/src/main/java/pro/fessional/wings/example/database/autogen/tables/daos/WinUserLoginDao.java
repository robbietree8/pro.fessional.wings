/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.example.database.autogen.tables.daos;


import org.jooq.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pro.fessional.wings.example.database.autogen.tables.WinUserLoginTable;
import pro.fessional.wings.example.database.autogen.tables.pojos.WinUserLogin;
import pro.fessional.wings.example.database.autogen.tables.records.WinUserLoginRecord;
import pro.fessional.wings.faceless.database.common.WingsJooqDaoImpl;

import javax.annotation.Generated;
import java.time.LocalDateTime;
import java.util.List;


/**
 * The table <code>wings_example.win_user_login</code>.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4",
        "schema version:2019070403"
    },
    date = "2020-07-09T09:12:23.997Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class WinUserLoginDao extends WingsJooqDaoImpl<WinUserLoginTable, WinUserLoginRecord, WinUserLogin, Long> {

    /**
     * Create a new WinUserLoginDao without any configuration
     */
    public WinUserLoginDao() {
        super(WinUserLoginTable.WinUserLogin, WinUserLoginTable.asA2, WinUserLogin.class);
    }

    /**
     * Create a new WinUserLoginDao with an attached configuration
     */
    @Autowired
    public WinUserLoginDao(Configuration configuration) {
        super(WinUserLoginTable.WinUserLogin, WinUserLoginTable.asA2, WinUserLogin.class, configuration);
    }

    @Override
    public Long getId(WinUserLogin object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<WinUserLogin> fetchById(Long... values) {
        return fetch(WinUserLoginTable.WinUserLogin.Id, values);
    }
    public List<WinUserLogin> fetchByIdLive(Long... values) {
        return fetchLive(WinUserLoginTable.WinUserLogin.Id, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public WinUserLogin fetchOneById(Long value) {
        return fetchOne(WinUserLoginTable.WinUserLogin.Id, value);
    }
    public WinUserLogin fetchOneByIdLive(Long value) {
        return fetchOneLive(WinUserLoginTable.WinUserLogin.Id, value);
    }

    /**
     * Fetch records that have <code>create_dt IN (values)</code>
     */
    public List<WinUserLogin> fetchByCreateDt(LocalDateTime... values) {
        return fetch(WinUserLoginTable.WinUserLogin.CreateDt, values);
    }
    public List<WinUserLogin> fetchByCreateDtLive(LocalDateTime... values) {
        return fetchLive(WinUserLoginTable.WinUserLogin.CreateDt, values);
    }

    /**
     * Fetch records that have <code>modify_dt IN (values)</code>
     */
    public List<WinUserLogin> fetchByModifyDt(LocalDateTime... values) {
        return fetch(WinUserLoginTable.WinUserLogin.ModifyDt, values);
    }
    public List<WinUserLogin> fetchByModifyDtLive(LocalDateTime... values) {
        return fetchLive(WinUserLoginTable.WinUserLogin.ModifyDt, values);
    }

    /**
     * Fetch records that have <code>delete_dt IN (values)</code>
     */
    public List<WinUserLogin> fetchByDeleteDt(LocalDateTime... values) {
        return fetch(WinUserLoginTable.WinUserLogin.DeleteDt, values);
    }
    public List<WinUserLogin> fetchByDeleteDtLive(LocalDateTime... values) {
        return fetchLive(WinUserLoginTable.WinUserLogin.DeleteDt, values);
    }

    /**
     * Fetch records that have <code>commit_id IN (values)</code>
     */
    public List<WinUserLogin> fetchByCommitId(Long... values) {
        return fetch(WinUserLoginTable.WinUserLogin.CommitId, values);
    }
    public List<WinUserLogin> fetchByCommitIdLive(Long... values) {
        return fetchLive(WinUserLoginTable.WinUserLogin.CommitId, values);
    }

    /**
     * Fetch records that have <code>user_id IN (values)</code>
     */
    public List<WinUserLogin> fetchByUserId(Long... values) {
        return fetch(WinUserLoginTable.WinUserLogin.UserId, values);
    }
    public List<WinUserLogin> fetchByUserIdLive(Long... values) {
        return fetchLive(WinUserLoginTable.WinUserLogin.UserId, values);
    }

    /**
     * Fetch records that have <code>login_type IN (values)</code>
     */
    public List<WinUserLogin> fetchByLoginType(Integer... values) {
        return fetch(WinUserLoginTable.WinUserLogin.LoginType, values);
    }
    public List<WinUserLogin> fetchByLoginTypeLive(Integer... values) {
        return fetchLive(WinUserLoginTable.WinUserLogin.LoginType, values);
    }

    /**
     * Fetch records that have <code>login_name IN (values)</code>
     */
    public List<WinUserLogin> fetchByLoginName(String... values) {
        return fetch(WinUserLoginTable.WinUserLogin.LoginName, values);
    }
    public List<WinUserLogin> fetchByLoginNameLive(String... values) {
        return fetchLive(WinUserLoginTable.WinUserLogin.LoginName, values);
    }

    /**
     * Fetch records that have <code>login_pass IN (values)</code>
     */
    public List<WinUserLogin> fetchByLoginPass(String... values) {
        return fetch(WinUserLoginTable.WinUserLogin.LoginPass, values);
    }
    public List<WinUserLogin> fetchByLoginPassLive(String... values) {
        return fetchLive(WinUserLoginTable.WinUserLogin.LoginPass, values);
    }

    /**
     * Fetch records that have <code>login_salt IN (values)</code>
     */
    public List<WinUserLogin> fetchByLoginSalt(String... values) {
        return fetch(WinUserLoginTable.WinUserLogin.LoginSalt, values);
    }
    public List<WinUserLogin> fetchByLoginSaltLive(String... values) {
        return fetchLive(WinUserLoginTable.WinUserLogin.LoginSalt, values);
    }

    /**
     * Fetch records that have <code>login_para IN (values)</code>
     */
    public List<WinUserLogin> fetchByLoginPara(String... values) {
        return fetch(WinUserLoginTable.WinUserLogin.LoginPara, values);
    }
    public List<WinUserLogin> fetchByLoginParaLive(String... values) {
        return fetchLive(WinUserLoginTable.WinUserLogin.LoginPara, values);
    }

    /**
     * Fetch records that have <code>auth_code IN (values)</code>
     */
    public List<WinUserLogin> fetchByAuthCode(String... values) {
        return fetch(WinUserLoginTable.WinUserLogin.AuthCode, values);
    }
    public List<WinUserLogin> fetchByAuthCodeLive(String... values) {
        return fetchLive(WinUserLoginTable.WinUserLogin.AuthCode, values);
    }

    /**
     * Fetch records that have <code>bad_count IN (values)</code>
     */
    public List<WinUserLogin> fetchByBadCount(Integer... values) {
        return fetch(WinUserLoginTable.WinUserLogin.BadCount, values);
    }
    public List<WinUserLogin> fetchByBadCountLive(Integer... values) {
        return fetchLive(WinUserLoginTable.WinUserLogin.BadCount, values);
    }

    /**
     * Fetch records that have <code>status IN (values)</code>
     */
    public List<WinUserLogin> fetchByStatus(Integer... values) {
        return fetch(WinUserLoginTable.WinUserLogin.Status, values);
    }
    public List<WinUserLogin> fetchByStatusLive(Integer... values) {
        return fetchLive(WinUserLoginTable.WinUserLogin.Status, values);
    }
}
