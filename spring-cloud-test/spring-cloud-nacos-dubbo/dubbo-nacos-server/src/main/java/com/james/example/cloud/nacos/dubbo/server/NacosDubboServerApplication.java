package com.james.example.cloud.nacos.dubbo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created by James on 2020/3/22.
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.james.example.cloud.nacos.dubbo.dao.mapper")
public class NacosDubboServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosDubboServerApplication.class, args);
    }
}

