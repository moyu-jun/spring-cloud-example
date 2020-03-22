package com.james.example.cloud.nacos.dubbo.common.bean;

/**
 * 响应码枚举 - 可参考HTTP状态码的语义
 *
 * Created by James on 2020/1/3.
 */
public enum ResultCode {
    //成功
    SUCCESS( 200, "SUCCESS" ),
    //失败
    FAILURE( 400, "FAILURE" ),
    // 未登录
    UN_LOGIN( 401, "未登录" ),
    //未认证（签名错误、token错误）
    UNAUTHORIZED( 403, "未认证或Token失效" ),
    //未通过认证
    USER_UNAUTHORIZED( 402, "用户名或密码不正确" ),
    //接口不存在
    NOT_FOUND( 404, "接口不存在" ),
    //服务器内部错误
    INTERNAL_SERVER_ERROR( 500, "服务器内部错误" );

    private int code;
    private String desc;

    ResultCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


//
//    /**
//     * 通用状态码
//     */
//    public static class ResultCode {
//        /**
//         * 请求成功
//         */
//        public static final int SUCCESS = 20000;
//
//        /**
//         * 请求失败
//         */
//        public static final int FAIL = 20002;
//
//        /**
//         * 未登录
//         */
//        public static final int UN_LOGIN = 20003;
//
//        /**
//         * 熔断请求
//         */
//        public static final int BREAKING = 20004;
//
//        /**
//         * 非法请求
//         */
//        public static final int ILLEGAL_REQUEST = 50000;
//
//        /**
//         * 非法令牌
//         */
//        public static final int ILLEGAL_TOKEN = 50008;
//
//        /**
//         * 其他客户登录
//         */
//        public static final int OTHER_CLIENTS_LOGGED_IN = 50012;
//
//        /**
//         * 令牌已过期
//         */
//        public static final int TOKEN_EXPIRED = 50014;
//    }
}
