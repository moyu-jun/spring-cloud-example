package com.xingtuai.cloud.test.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author James
 * @date 2020/10/13
 */
@RestController
@RequestMapping("/test/rest")
public class TestController {


    @GetMapping("/echo")
    public String echo(String message){
        return "Test.Rest: echo message: " + message;
    }
}
