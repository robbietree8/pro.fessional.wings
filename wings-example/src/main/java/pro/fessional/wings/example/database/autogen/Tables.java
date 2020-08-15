/*
 * This file is generated by jOOQ.
 */
package pro.fessional.wings.example.database.autogen;


import javax.annotation.Generated;

import pro.fessional.wings.example.database.autogen.tables.SysConstantEnumTable;
import pro.fessional.wings.example.database.autogen.tables.SysStandardI18nTable;
import pro.fessional.wings.example.database.autogen.tables.WinAuthRoleTable;
import pro.fessional.wings.example.database.autogen.tables.WinUserLoginTable;
import pro.fessional.wings.example.database.autogen.tables.WinUserTable;


/**
 * Convenience access to all tables in 
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4",
        "schema version:2019070403"
    },
    date = "2020-08-13T07:33:30.191Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>sys_constant_enum</code>.
     */
    public static final SysConstantEnumTable SysConstantEnum = SysConstantEnumTable.SysConstantEnum;

    /**
     * The table <code>sys_standard_i18n</code>.
     */
    public static final SysStandardI18nTable SysStandardI18n = SysStandardI18nTable.SysStandardI18n;

    /**
     * The table <code>win_auth_role</code>.
     */
    public static final WinAuthRoleTable WinAuthRole = WinAuthRoleTable.WinAuthRole;

    /**
     * The table <code>win_user</code>.
     */
    public static final WinUserTable WinUser = WinUserTable.WinUser;

    /**
     * The table <code>win_user_login</code>.
     */
    public static final WinUserLoginTable WinUserLogin = WinUserLoginTable.WinUserLogin;
}
