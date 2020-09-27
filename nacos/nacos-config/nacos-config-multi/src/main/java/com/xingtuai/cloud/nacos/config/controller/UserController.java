package com.xingtuai.cloud.nacos.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author James
 * @date 2020/9/27
 */
@RefreshScope
@RestController
@RequestMapping("users")
public class UserController {


    @Value("${base.name}")
    String name;

    @Value("${base.age}")
    String age;

    @Value("${profiles.active}")
    String active;

    @GetMapping("/test")
    public String test() {
        return "name: " + name + "; age: " + age + "; active: " + active;
    }

}
