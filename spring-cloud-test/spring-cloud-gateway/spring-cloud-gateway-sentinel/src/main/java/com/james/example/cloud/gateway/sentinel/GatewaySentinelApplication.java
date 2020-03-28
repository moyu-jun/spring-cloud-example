package com.james.example.cloud.gateway.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by James on 2020/3/28.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewaySentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewaySentinelApplication.class, args);
    }
}
