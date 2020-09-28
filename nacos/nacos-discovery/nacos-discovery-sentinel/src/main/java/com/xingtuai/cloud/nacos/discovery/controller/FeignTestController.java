package com.xingtuai.cloud.nacos.discovery.controller;

import com.xingtuai.cloud.nacos.discovery.service.FeignEchoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author James
 * @date 2020/9/27
 */
@Slf4j
@RestController
@RequestMapping("feign")
public class FeignTestController {


    @Resource
    private FeignEchoService feignEchoService;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/echo")
    public String echoAppName() {
        return feignEchoService.echo(appName);
    }
}
