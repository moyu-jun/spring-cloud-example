package com.xingtuai.cloud.rocketmq.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 消息生产者服务
 *
 * @author James
 * @date 2020/12/15
 */
public interface MyMessageSource {

    @Input("input1")
    SubscribableChannel input1();

    @Input("input2")
    SubscribableChannel input2();

    @Input("input3")
    SubscribableChannel input3();
}
