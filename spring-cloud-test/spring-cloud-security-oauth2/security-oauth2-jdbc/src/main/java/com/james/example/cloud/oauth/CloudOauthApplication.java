package com.james.example.cloud.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author James
 * @date 2020/4/23
 */
@SpringBootApplication
@MapperScan("com.james.example.cloud.oauth.mapper")
public class CloudOauthApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudOauthApplication.class, args);
    }
}
