package com.james.example.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author James
 * @date 2020/3/26
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue defaultQueue() {
        return new Queue("log_queue");
    }
}
