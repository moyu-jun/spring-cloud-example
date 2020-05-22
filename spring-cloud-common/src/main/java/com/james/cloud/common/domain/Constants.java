package com.james.cloud.common.domain;

/**
 * @author James
 * @date 2020/5/18
 */
public class Constants {

    /**
     * 请求头类型：
     * application/json ： json格式
     */
    public static final String REQUEST_HEADER_CONTENT_TYPE_JSON = "application/json";
    public static final String REQUEST_HEADER_ENCODING = "UTF-8";


    /*********    UPMS 系统常量   *********/
    public static final byte UPMS_USER_STATE_LOCKED_ENABLE = 1;  // 用户锁定状态：正常
    public static final byte UPMS_USER_STATE_LOCKED_DISABLE = 0; // 用户锁定状态：禁用

    public static final String UPMS_USER_STATE_LOCKED_ENABLE_VALUE = "正常";  // 用户锁定状态：正常
    public static final String UPMS_USER_STATE_LOCKED_DISABLE_VALUE = "禁用"; // 用户锁定状态：禁用

    public static final String UPMS_USER_SUPER_ADMIN_NAME = "admin";    // 超级管理员用户名
    public static final String UPMS_ROLE_SUPER_ADMIN_NAME = "admin";    // 超级管理员角色名

    public static final String UPMS_LOGIN_STATUS_LOGIN = "login";
    public static final String UPMS_LOGIN_STATUS_LOGOUT = "logout";


}
