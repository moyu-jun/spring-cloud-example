package com.xingtuai.cloud.test.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author James
 * @date 2020/10/13
 */
@SpringBootApplication
@EnableDiscoveryClient
public class TestRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestRestApplication.class, args);
    }
}
