package com.xingtuai.cloud.nacos.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 * RefreshScope 使 Nacos Config 配置内容支持动态刷新
 *
 * @author James
 * @date 2020/9/25
 */
@RefreshScope
@RestController
public class TestController {

    @Value("${user.name}")
    String name;

    @Value("${user.age}")
    String age;

    @GetMapping("/name")
    public String getName() {
        return name;
    }

    @GetMapping("/age")
    public String getAge() {
        return age;
    }
}
