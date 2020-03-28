package com.james.example.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by James on 2020/3/26.
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue defaultQueue() {
        return new Queue("hello");
    }
}
