package com.james.example.cloud.nacos.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by James on 2020/3/19.
 */
@Slf4j
@RestController
public class TestController {

    @Resource
    Client client;

    @GetMapping("/test")
    public String test(){
        // 使用 openfeign 进行服务调用
        String result = client.hello("James");
        return "return : " + result;
    }

    @FeignClient("spring-cloud-provider")
    interface Client {
        @GetMapping("/hello")
        String hello(@RequestParam(name = "name") String name);
    }
}
