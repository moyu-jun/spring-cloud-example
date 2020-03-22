package com.james.example.cloud.nacos.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by James on 2020/3/19.
 */
@Slf4j
@RestController
public class TestController {


    @GetMapping("/hello")
    public String hello(@RequestParam String name){
        log.info("invoked name = " + name);
        return "hello " + name;
    }

}
