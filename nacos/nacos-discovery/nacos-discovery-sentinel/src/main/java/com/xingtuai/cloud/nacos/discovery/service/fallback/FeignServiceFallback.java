package com.xingtuai.cloud.nacos.discovery.service.fallback;

import com.xingtuai.cloud.nacos.discovery.service.FeignService;

/**
 * @author James
 * @date 2020/9/28
 */
public class FeignServiceFallback implements FeignService {

    @Override
    public String echo(String message) {
        return "echo fallback, please try again.";
    }
}
