package com.james.example.activemq.controller;

import com.james.example.activemq.mq.ProducerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by James on 2020/3/26.
 */
@RestController
public class TestController {


    @Resource
    private ProducerService producerService;

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message){
        producerService.sendMessage(message);
//        jmsMessagingTemplate.convertAndSend(message);
        return "SUCCESS";
    }

    @GetMapping("/topic/send")
    public String sendMessageToTopic(@RequestParam String message){
        producerService.sendMessageToTopic(message);
//        jmsMessagingTemplate.convertAndSend(message);
        return "SUCCESS";
    }
}
