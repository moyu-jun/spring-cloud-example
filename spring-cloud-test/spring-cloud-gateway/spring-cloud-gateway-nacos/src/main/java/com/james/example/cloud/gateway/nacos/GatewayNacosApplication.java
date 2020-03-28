package com.james.example.cloud.gateway.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by James on 2020/3/28.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayNacosApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayNacosApplication.class, args);
    }
}
