package com.xingtuai.cloud.nacos.config.controller;

import com.xingtuai.cloud.common.entity.ResponseResult;
import com.xingtuai.cloud.nacos.config.domain.SysUser;
import com.xingtuai.cloud.nacos.config.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author James
 * @date 2020/9/25
 */
@Slf4j
@RefreshScope
@RestController
@RequestMapping("users")
public class UserController {

    @Resource
    private SysUserService userService;

    @Value("${user.name}")
    String name;

    @Value("${common.test}")
    String commonTest;

    @GetMapping("/{id}")
    public ResponseResult getUser(@PathVariable Long id){

        log.info("接口进入   ---->   获取用户信息");
        log.info("请求参数：id = {}", id);

        SysUser user = userService.getUser(id);
        return ResponseResult.ok(user);
    }


    @GetMapping("/test")
    public String test() {
        return name + ":" + commonTest;
    }
}
