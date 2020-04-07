package com.james.example.cloud.sentinel.advanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by James on 2020/4/7.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelAdvancedApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelAdvancedApplication.class, args);
    }
}
