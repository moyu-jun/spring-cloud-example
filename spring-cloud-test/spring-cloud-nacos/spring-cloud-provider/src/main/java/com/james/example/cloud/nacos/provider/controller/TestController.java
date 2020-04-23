package com.james.example.cloud.nacos.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by James on 2020/3/19.
 */
@Slf4j
@RestController
public class TestController {

    @Value("${server.port}")
    private String port;

    private int a = 0;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        a++;
        log.info("invoked name = " + name + "; a = " + a);
        return "hello " + name + "; port"  + port;
    }


    @GetMapping("/test")
    public String test() {
        a++;
        log.info("invoked a = " + a);
        return "port"  + port;
    }
}