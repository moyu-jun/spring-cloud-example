package com.xingtuai.cloud.nacos.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author James
 * @date 2020/9/25
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.xingtuai.cloud.nacos.config.mapper")
public class NacosConfigAdvancedApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigAdvancedApplication.class, args);
    }
}
