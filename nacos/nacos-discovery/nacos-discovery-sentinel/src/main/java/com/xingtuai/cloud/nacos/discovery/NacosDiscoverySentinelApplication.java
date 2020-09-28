package com.xingtuai.cloud.nacos.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author James
 * @date 2020/9/27
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.xingtuai.cloud.nacos.discovery.mapper")
public class NacosDiscoverySentinelApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosDiscoverySentinelApplication.class, args);
    }
}
