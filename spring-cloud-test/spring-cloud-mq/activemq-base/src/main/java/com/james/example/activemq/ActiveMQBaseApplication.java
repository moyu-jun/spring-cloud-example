package com.james.example.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * Created by James on 2020/3/26.
 */
@SpringBootApplication
@EnableJms
public class ActiveMQBaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActiveMQBaseApplication.class, args);
    }
}
