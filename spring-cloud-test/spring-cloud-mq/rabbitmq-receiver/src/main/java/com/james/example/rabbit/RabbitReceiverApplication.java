package com.james.example.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author James
 * @date 2020/6/1
 */
@SpringBootApplication
public class RabbitReceiverApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitReceiverApplication.class, args);
    }
}
