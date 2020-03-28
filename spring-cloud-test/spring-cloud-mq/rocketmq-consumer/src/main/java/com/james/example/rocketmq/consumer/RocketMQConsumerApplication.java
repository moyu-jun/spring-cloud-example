package com.james.example.rocketmq.consumer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

import javax.annotation.Resource;

/**
 * Created by James on 2020/3/29.
 */
@SpringBootApplication
@EnableBinding({Sink.class}) // Source 为提供者
public class RocketMQConsumerApplication{

//    @Resource
//    ConsumerReceive consumerReceive;

    public static void main(String[] args) {
        SpringApplication.run(RocketMQConsumerApplication.class, args);
    }

//    @StreamListener("input")
//    public void receiverInput(String message){
//        System.out.println("input receive: " + message);
//    }
}
