package com.james.example.activemq.mq.impl;

import com.james.example.activemq.mq.ProducerService;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * Created by James on 2020/3/26.
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Resource
    private Queue queue;

    @Resource
    private Topic topic;

    @Override
    public void sendMessage(Destination destination, String message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    @Override
    public void sendMessage(String message) {
        jmsMessagingTemplate.convertAndSend(this.queue, message);
    }

    @Override
    public void sendMessageToTopic(String message) {
        jmsMessagingTemplate.convertAndSend(this.topic, message);
    }
}
