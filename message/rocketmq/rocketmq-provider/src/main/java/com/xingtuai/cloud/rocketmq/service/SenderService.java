package com.xingtuai.cloud.rocketmq.service;

/**
 * @author James
 * @date 2020/12/15
 */
public interface SenderService {

    /**
     * 发送字符串
     * @param msg
     */
    void send(String msg);

    /**
     * 发送带 Tag 的字符串
     *
     * @param msg
     * @param tag
     */
    void sendWithTags(String msg, String tag);

    /**
     * 发送对象
     *
     * @param msg
     * @param tag
     * @param <T>
     */
    <T> void sendObject(T msg, String tag);
}
