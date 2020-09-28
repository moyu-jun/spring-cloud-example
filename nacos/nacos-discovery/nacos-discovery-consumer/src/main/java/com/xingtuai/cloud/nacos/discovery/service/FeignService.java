package com.xingtuai.cloud.nacos.discovery.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author James
 * @date 2020/9/28
 */
@FeignClient("nacos-discovery-provider")
public interface FeignService {

    /**
     * 接口定义
     *
     * @param message
     * @return
     */
    @GetMapping("/echo/{message}")
    public String echo(@PathVariable String message);
}
