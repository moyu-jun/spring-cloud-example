package com.xingtuai.cloud.rocketmq.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 消息生产者服务
 *
 * @author James
 * @date 2020/12/15
 */
public interface MyMessageSource {

    @Output("testOutput")
    MessageChannel testOutput();

    @Output("baseOutput")
    MessageChannel baseOutput();

}
