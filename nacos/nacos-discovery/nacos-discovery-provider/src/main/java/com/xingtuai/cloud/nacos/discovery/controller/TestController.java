package com.xingtuai.cloud.nacos.discovery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author James
 * @date 2020/9/27
 */
@RestController
@RequestMapping
public class TestController {

    @GetMapping("/echo/{message}")
    public String echo(@PathVariable String message) {

        return "Hello Nacos Discovery " + message;
    }
}
