package com.james.example.activemq.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by James on 2020/3/26.
 */
@Component
public class ConsumerListener {

    @JmsListener(destination = "springboot.queue")
    public void receiver(String message){
        System.out.println("消费者接收到QUEUE消息：" + message);
    }

    @JmsListener(destination = "SpringBootTopic",containerFactory = "jmsTopicListenerContainerFactory")
    public void receiverTopic(String message){
        System.out.println("消费者接收到TOPIC消息：" + message);
    }
}
