package com.xingtuai.cloud.nacos.discovery.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SentinelResource 注解需要的切面。不配置这个将不生效
 *
 * @author James
 * @date 2020/9/28
 */
@Configuration
public class SentinelAspectConfig {
    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }
}
