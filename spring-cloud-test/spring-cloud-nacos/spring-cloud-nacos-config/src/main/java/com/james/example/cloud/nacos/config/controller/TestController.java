package com.james.example.cloud.nacos.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by James on 2020/3/23.
 */
@RestController
@RefreshScope   // 使配置内容支持动态刷新
public class TestController {

    @Value("${user.name}")
    String name;

    @RequestMapping("/name")
    public String getName() {
        return name;
    }
}
