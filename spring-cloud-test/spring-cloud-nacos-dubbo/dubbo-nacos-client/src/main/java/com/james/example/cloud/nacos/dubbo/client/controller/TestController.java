package com.james.example.cloud.nacos.dubbo.client.controller;


import com.james.example.cloud.nacos.dubbo.api.UpmsUserService;
import com.james.example.cloud.nacos.dubbo.common.bean.ResponseResult;
import com.james.example.cloud.nacos.dubbo.dao.domain.UpmsUser;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by James on 2020/3/22.
 */
@RestController
@RequestMapping("user")
public class TestController {

    @Reference(version = "1.0.0")
    private UpmsUserService upmsUserService;

    @GetMapping(value = "/user")
    public ResponseResult getUser(@RequestParam String username){
        UpmsUser upmsUser = upmsUserService.selectByName(username);
        return ResponseResult.ok("获取成功", upmsUser);
    }

    @GetMapping(value = "/userById")
    public ResponseResult getUser(@RequestParam Integer id){
        UpmsUser upmsUser = upmsUserService.select(id);
        return ResponseResult.ok("获取成功", upmsUser);
    }
}
