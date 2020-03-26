package com.james.example.activemq.mq;


import javax.jms.Destination;

/**
 * Created by James on 2020/3/26.
 */
public interface ProducerService {

    /**
     * Description: 指定消息队列，以及对应的消息
     * @param destination
     * @param message
     */
    void sendMessage(Destination destination, final String message);

    /**
     * Description: 使用默认消息队列，发送消息
     * @param message
     */
    void sendMessage(final String message);

    void sendMessageToTopic(final String message);
}
