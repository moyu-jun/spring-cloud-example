package com.xingtuai.cloud.nacos.discovery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author James
 * @date 2020/9/27
 */
@Component
public class RestTemplateConfig {

    /**
     * 实例化 RestTemplate 实例
     *
     * @return
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
