package com.james.example.cloud.oauth.resource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author James
 * @date 2020/4/25
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test!";
    }

    @GetMapping("/update")
    public String update(){
        return "test update!";
    }
}
