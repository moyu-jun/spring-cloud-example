package com.james.example.cloud.nacos.dubbo.common.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * 通用数据传输对象
 */
public class ResponseResult implements Serializable {

    private static final long serialVersionUID = 5805390369358950390L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;

    /**
     * 返回对象
     */
    private Object data;

    /***
     * 过期
     */
    public static ResponseResult expired(String message) {
        return new ResponseResult(ResultCode.UN_LOGIN.getCode(), message);
    }

    public static ResponseResult fail(String message) {
        return new ResponseResult(ResultCode.FAILURE.getCode(), message);
    }


    /***
     * 自定义错误返回码
     *
     * @param code
     * @param message:
     * @return
     */
    public static ResponseResult fail(Integer code, String message) {
        return new ResponseResult(code, message);
    }

    public static ResponseResult ok() {
        return new ResponseResult(ResultCode.SUCCESS.getCode(), "OK");
    }

    public static ResponseResult ok(String message) {
        return new ResponseResult(ResultCode.SUCCESS.getCode(), message);
    }

    public static ResponseResult ok(Object data) {
        return new ResponseResult(ResultCode.SUCCESS.getCode(), "", data);
    }

    /**
     * 自定义返回码
     */
    public static ResponseResult ok(Integer code, String message) {
        return new ResponseResult(code, message);
    }


    public static ResponseResult ok(String message, Object data) {
        return new ResponseResult(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 自定义
     *
     * @param code：验证码
     * @param message：返回消息内容
     * @param data：返回数据
     * @return
     */
    public static ResponseResult ok(Integer code, String message, Object data) {
        return new ResponseResult(code, message, data);
    }

    public static ResponseResult build(Integer code, String msg, Object data) {
        return new ResponseResult(ResultCode.SUCCESS.getCode(), msg, data);
    }





    public ResponseResult() {
        super();
    }

    public ResponseResult(Integer code) {
        super();
        this.code = code;
    }

    public ResponseResult(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ResponseResult(Integer code, Throwable throwable) {
        super();
        this.code = code;
        this.message = throwable.getMessage();
    }

    public ResponseResult(Integer code, Object data) {
        super();
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code, String message, Object data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseResult that = (ResponseResult) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(message, that.message) &&
                Objects.equals(data, that.data);
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
