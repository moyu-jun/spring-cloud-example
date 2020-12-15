package com.xingtuai.cloud.rocketmq.service;

import com.xingtuai.cloud.rocketmq.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * @author James
 * @date 2020/12/15
 */
@Slf4j
@Service
public class ReceiveService {
    @StreamListener("input1")
    public void receiveInput1(String receiveMsg) {
        log.info("input1 接收到了消息：" + receiveMsg);
    }

    @StreamListener("input2")
    public void receiveInput2(String receiveMsg) {
        log.info("input2 接收到了消息：" + receiveMsg);
    }

    @StreamListener("input3")
    public void receiveInput3(@Payload User foo) {
        log.info("input3 接收到了消息：" + foo);
    }
}
