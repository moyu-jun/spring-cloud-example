package com.xingtuai.cloud.nacos.discovery.service.config;

import com.xingtuai.cloud.nacos.discovery.service.fallback.EchoServiceFallback;
import org.springframework.context.annotation.Bean;

/**
 * @author James
 * @date 2020/9/28
 */
public class FeignConfig {

    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }
}
