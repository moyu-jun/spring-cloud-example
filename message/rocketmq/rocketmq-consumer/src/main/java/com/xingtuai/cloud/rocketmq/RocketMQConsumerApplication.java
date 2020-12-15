package com.xingtuai.cloud.rocketmq;

import com.xingtuai.cloud.rocketmq.config.MyMessageSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author James
 * @date 2020/12/15
 */
@SpringBootApplication
@EnableBinding({MyMessageSource.class})
public class RocketMQConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketMQConsumerApplication.class, args);
    }
}
