package com.james.example.cloud.oauth.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author James
 * @date 2020/4/24
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AuthResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthResourceApplication.class, args);
    }
}
