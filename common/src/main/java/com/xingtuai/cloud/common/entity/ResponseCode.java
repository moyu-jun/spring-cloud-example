package com.xingtuai.cloud.common.entity;

/**
 * 通过接口返回的状态码
 * 状态码共 5 位，错误码命名规则：错误产生来源 + 四位数字编号
 * <p>
 * 错误产生来源：
 * 1xxxx : 错误来源于客户端
 * 2xxxx : 错误来源于当前系统
 * 3xxxx : 错误来源于第三方，如 CDN、RPC
 * <p>
 * 四位数字编号从 0001 到 9999，大类之间的步长间距预留 100
 * <p>
 * 编号确定之后，永久固定，不得修改。
 *
 * @author James
 * @date 2020/9/24
 */
public enum ResponseCode {
    /**
     * 成功返回，一切 OK
     */
    SUCCESS(0, "操作成功"),

    /**
     * 一级宏观错误码
     * 客户端错误
     */
    CLIENT(10000, "客户端错误"),

    /**
     * 二级宏观错误码
     * 客户端请求参数异常（10101 - 10199）
     */
    CLIENT_PARAM(10101, "客户端请求参数异常"),
    CLIENT_PARAM_REQUIRED_IS_NULL(10101, "请求必填参数为空"),
    CLIENT_PARAM_FORMAT_INVALID(10102, "参数格式不匹配"),
    CLIENT_PARAM_INPUT_INVALID(10103, "无效的用户输入"),
    CLIENT_PARAM_JSON_PARSE_FAILED(10104, "请求 JSON 解析失败"),
    CLIENT_PARAM_INCLUDE_ILLEGAL_WORDS(10105, "包含违禁敏感词"),
    CLIENT_PARAM_VALUE_OUT_RANGE(10106, "请求参数值超出允许的范围"),

    CLIENT_PARAM_NAME_IS_NULL(10110, "用户名为空"),
    CLIENT_PARAM_NAME_INVALID(10111, "用户名不合法"),
    CLIENT_PARAM_NAME_EXIST(10112, "用户名已存在"),
    CLIENT_PARAM_NAME_SENSITIVE(10113, "用户名包含敏感词"),
    CLIENT_PARAM_NAME_SPECIAL(10114, "用户名包含特殊字符"),

    CLIENT_PARAM_PASSWORD_IS_NULL(10120, "密码为空"),
    CLIENT_PARAM_PASSWORD_INVALID(10121, "密码校验失败"),
    CLIENT_PARAM_PASSWORD_SHORT(10122, "密码长度不够"),
    CLIENT_PARAM_PASSWORD_WEAK(10123, "密码强度不够"),

    CLIENT_PARAM_CODE_INVALID(10130, "校验码输入错误"),
    CLIENT_PARAM_SMS_CODE_INVALID(10131, "短信校验码输入错误"),
    CLIENT_PARAM_MAIL_CODE_INVALID(10132, "邮件校验码输入错误"),
    CLIENT_PARAM_VOICE_CODE_INVALID(10133, "语音校验码输入错误"),

    CLIENT_PARAM_BASE_INFO_INVALID(10150, "用户基本信息校验失败"),
    CLIENT_PARAM_MOBILE_INVALID(10151, "手机号格式不合法"),
    CLIENT_PARAM_MOBILE_BOUND(10152, "手机号已被绑定"),
    CLIENT_PARAM_ADDRESS_INVALID(10153, "地址格式校验失败"),
    CLIENT_PARAM_EMAIL_INVALID(10154, "邮箱格式不合法"),
    CLIENT_PARAM_EMAIL_BOUND(10155, "邮箱已被绑定"),

    /**
     * 二级宏观错误码
     * 认证授权异常（10200 - 10299）
     */
    CLIENT_AUTH(10200, "认证授权异常"),
    CLIENT_AUTH_ACCESS_DENIED(10201, "访问未授权"),
    CLIENT_AUTH_AUTHORIZING(10202, "正在授权中"),
    CLIENT_AUTH_REJECTED(10203, "用户授权申请被拒绝"),
    CLIENT_AUTH_EXPIRED(10204, "授权已过期"),
    CLIENT_AUTH_NO_PERMISSION(10205, "权限不足"),
    CLIENT_AUTH_REQUEST_INTERCEPTED(10206, "用户访问被拦截"),
    CLIENT_AUTH_BLACKLIST(10207, "黑名单用户"),
    CLIENT_AUTH_ACCOUNT_LOCKED(10208, "账号被冻结"),
    CLIENT_AUTH_IP_INVALID(10209, "非法 IP 地址"),
    CLIENT_AUTH_GATEWAY_ACCESS_DENIED(10210, "网关访问受限"),
    CLIENT_AUTH_REGION_BLACKLIST(10211, "地域黑名单"),
    CLIENT_AUTH_SERVICE_OVERDUE(10212, "服务已欠费"),
    CLIENT_AUTH_SIGNATURE_INVALID(10213, "用户签名异常"),
    CLIENT_AUTH_RSA_SIGNATURE_ERROR(10214, "RSA 签名错误"),
    // TODO 认证中心所需的异常返回码
    CLIENT_AUTH_CLIENT_INVALID(10215, "无效的客户端"),
    CLIENT_AUTH_CLIENT_UNAUTHORIZED(10216, "未经授权的客户端"),
    CLIENT_AUTH_GRANT_INVALID(10217, "认证失败"),
    CLIENT_AUTH_SCOPE_INVALID(10218, "无效的认证范围"),
    CLIENT_AUTH_TOKEN_INVALID(10219, "无效的 token"),
    CLIENT_AUTH_REQUEST_INVALID(10220, "无效的请求"),
    CLIENT_AUTH_REDIRECT_MISMATCH(10221, "重定向 URL 不匹配"),
    CLIENT_AUTH_GRANT_TYPE_UNSUPPORTED(10222, "不支持的认证类型"),
    CLIENT_AUTH_RESPONSE_TYPE_UNSUPPORTED(10223, "不支持的响应类型"),
    CLIENT_AUTH_INTERCEPTED_FOR_PRIVACY(10224, "因访问对象隐私设置被拦截"),

    /**
     * 二级宏观错误码
     * 用户上传文件异常（10300 - 10399）
     */
    CLIENT_UPLOAD(10300, "用户上传文件异常"),
    CLIENT_UPLOAD_FILE_TYPE_MISMATCH(10301, "用户上传文件类型不匹配"),
    CLIENT_UPLOAD_FILE_TOO_LARGE(10302, "用户上传文件太大"),
    CLIENT_UPLOAD_IMAGE_TOO_LARGE(10303, "用户上传图片太大"),
    CLIENT_UPLOAD_VIDEO_TOO_LAGER(10304, "用户上传视频太大"),
    CLIENT_UPLOAD_ZIP_FILE_TOO_LARGE(10305, "用户上传压缩文件太大"),


    /**
     * 一级宏观错误码
     *
     * 系统执行出错
     */
    SYSTEM(20000, "系统执行出错"),
    /**
     * 二级宏观错误码
     * 系统执行超时
     */
    SYSTEM_TIMEOUT_RUNNING(20100, "系统执行超时"),
    SYSTEM_TIMEOUT_ORDER_PROCESS(20101, "系统订单处理超时"),
    SYSTEM_DISASTER_RECOVERY_TRIGGER(20200, "系统容灾功能被触发"),
    SYSTEM_CURRENT_LIMITING(20210, "系统限流"),
    SYSTEM_DEMOTION(20220, "系统功能降级"),
    /**
     * 二级宏观错误码
     * 系统资源异常
     */
    SYSTEM_RESOURCE(20300, "系统资源异常"),
    SYSTEM_RESOURCE_OVER(20310, "系统资源耗尽"),
    SYSTEM_RESOURCE_DISK_OVER(20311, "系统磁盘空间耗尽"),
    SYSTEM_RESOURCE_MEMORY_OVER(20312, "系统内存耗尽"),
    SYSTEM_RESOURCE_FILE_HANDLE_OVER(20313, "文件句柄耗尽"),
    SYSTEM_RESOURCE_CONNECT_POOL_OVER(20314, "系统连接池耗尽"),
    SYSTEM_RESOURCE_THREAD_POOL_OVER(20315, "系统线程池耗尽"),
    SYSTEM_RESOURCE_ACCESS_DENIED(20320, "系统资源访问异常"),
    SYSTEM_RESOURCE_READ_DISK_FILE_FAILED(20321, "系统读取磁盘文件失败"),

    /**
     * 一级宏观错误码
     *
     * 调用第三方服务出错
     */
    THIRD(30000, "调用第三方服务出错"),

    /**
     * 二级宏观错误码
     * 中间件服务出错
     */
    THIRD_MIDDLE(30100, "中间件服务出错"),
    THIRD_MIDDLE_RPC(30110, "RPC 服务出错"),
    THIRD_MIDDLE_RPC_NOT_FOUND(30111, "RPC 服务未找到"),
    THIRD_MIDDLE_RPC_NOT_REGISTER(30112, "RPC 服务未注册"),
    THIRD_MIDDLE_INTERFACE_NOT_EXIST(30113, "接口不存在"),
    THIRD_MIDDLE_MESSAGE(30120, "消息服务出错"),
    THIRD_MIDDLE_MESSAGE_SEND_FAILED(30121, "消息投递出错"),
    THIRD_MIDDLE_MESSAGE_CONSUME_FAILED(30122, "消息消费出错"),
    THIRD_MIDDLE_MESSAGE_SUBSCRIBE_FAILED(30123, "消息订阅出错"),
    THIRD_MIDDLE_MESSAGE_GROUP_NOT_FOUND(30124, "消息分组未查到"),
    THIRD_MIDDLE_CACHE(30130, "缓存服务出错"),
    THIRD_MIDDLE_CACHE_KEY_TOO_LONG(30131, "key 长度超过限制"),
    THIRD_MIDDLE_CACHE_VALUE_TOO_LONG(30132, "value 长度超过限制"),
    THIRD_MIDDLE_CACHE_STORAGE_OVER(30133, "存储容量已满"),
    THIRD_MIDDLE_CACHE_DATA_FORMAT_NOT_SUPPORT(30134, "不支持的数据格式"),
    THIRD_MIDDLE_CONFIG_SERVICE(30140, "配置服务出错"),
    THIRD_MIDDLE_NET_RESOURCE_ERROR(30150, "网络资源服务出错"),
    THIRD_MIDDLE_VPN_ERROR(30151, "VPN 服务出错"),
    THIRD_MIDDLE_CDN_ERROR(30152, "CDN 服务出错"),
    THIRD_MIDDLE_DNS_ERROR(30153, "域名解析服务出错"),
    THIRD_MIDDLE_GATEWAY_ERROR(30154, "网关服务出错"),

    /**
     * 二级宏观错误码
     * 第三方系统执行超时
     */
    THIRD_TIMEOUT(30200, "第三方系统执行超时"),
    THIRD_TIMEOUT_RPC(30210, "RPC 执行超时"),
    THIRD_TIMEOUT_MESSAGE_SEND(30220, "消息投递超时"),
    THIRD_TIMEOUT_CACHE(30230, "缓存服务超时"),
    THIRD_TIMEOUT_CONFIG(30240, "配置服务超时"),
    THIRD_TIMEOUT_MYSQL(30250, "数据库服务超时"),

    /**
     * 二级宏观错误码
     * 数据库服务出错
     */
    THIRD_DATABASE(30300, "数据库服务出错"),
    THIRD_DATABASE_TABLE_NOT_FOUND(30311, "表不存在"),
    THIRD_DATABASE_COLUMN_NOT_FOUND(30312, "列不存在"),
    THIRD_DATABASE_INCLUDE_SAME_COLUMN(30321, "多表关联中存在多个相同名称的列"),
    THIRD_DATABASE_DEADLOCK(30331, "数据库死锁"),
    THIRD_DATABASE_PRIMARY_KEY_CONFLICT(30341, "主键冲突"),

    /**
     * 二级宏观错误码
     * 第三方容灾系统被触发
     */
    THIRD_DISASTER_RECOVERY(30400, "第三方容灾系统被触发"),
    THIRD__CURRENT_LIMITING(30401, "第三方系统限流"),
    THIRD_DEMOTION(30402, "第三方功能降级"),

    /**
     * 二级宏观错误码
     * 通知服务出错
     */
    THIRD_NOTICE(30500, "通知服务出错"),
    THIRD_NOTICE_SMS_FAILED(30501, "短信提醒服务失败"),
    THIRD_NOTICE_VOICE_FAILED(30502, "语音提醒服务失败"),
    THIRD_NOTICE_EMAIL_FAILED(30503, "邮件提醒服务失败");


    private Integer code;
    private String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
