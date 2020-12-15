package com.xingtuai.cloud.rocketmq.service.impl;

import com.xingtuai.cloud.rocketmq.config.MyMessageSource;
import com.xingtuai.cloud.rocketmq.service.SenderService;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import javax.annotation.Resource;

/**
 * @author James
 * @date 2020/12/15
 */
@Service
public class SenderServiceImpl implements SenderService {

    @Resource
    private MyMessageSource myMessageSource;

    @Override
    public void send(String msg) {
        Message<String> message = MessageBuilder.withPayload(msg)
                .build();
        myMessageSource.testOutput().send(message);
    }

    @Override
    public void sendWithTags(String msg, String tag) {
        Message<String> message = MessageBuilder.withPayload(msg)
                .setHeader(RocketMQHeaders.TAGS, tag)
                .build();
        myMessageSource.testOutput().send(message);
    }

    @Override
    public <T> void sendObject(T msg, String tag) {
        Message<T> message = MessageBuilder.withPayload(msg)
                .setHeader(RocketMQHeaders.TAGS, tag)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();
        myMessageSource.baseOutput().send(message);
    }
}
