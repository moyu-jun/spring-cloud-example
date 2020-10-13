package com.xingtuai.cloud.nacos.discovery.service.config;

import com.xingtuai.cloud.nacos.discovery.service.fallback.FeignServiceFallback;
import org.springframework.context.annotation.Bean;

/**
 * @author James
 * @date 2020/9/28
 */
public class FeignConfig {

    @Bean
    public FeignServiceFallback feignServiceFallback() {
        return new FeignServiceFallback();
    }
}
