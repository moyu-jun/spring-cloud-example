package com.james.example.monitor.admin.nacos.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by James on 2020/3/25.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AdminNacosClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminNacosClientApplication.class, args);
    }
}
