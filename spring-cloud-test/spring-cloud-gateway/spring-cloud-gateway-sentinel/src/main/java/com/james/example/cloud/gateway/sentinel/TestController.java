package com.james.example.cloud.gateway.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by James on 2020/3/28.
 */
@RestController
public class TestController {

    @SentinelResource("resource")
    @GetMapping("/hello")
    public String hello(){
        return "Hello Sentinel";
    }
}


