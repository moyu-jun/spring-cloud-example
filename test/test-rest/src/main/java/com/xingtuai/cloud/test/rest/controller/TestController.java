package com.xingtuai.cloud.test.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author James
 * @date 2020/10/13
 */
@RestController
@RequestMapping
public class TestController {


    @GetMapping("/echo")
    public String echo(String message){
        return "echo message: " + message;
    }
}
