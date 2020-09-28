package com.xingtuai.cloud.nacos.discovery.controller;

import com.xingtuai.cloud.common.entity.ResponseResult;
import com.xingtuai.cloud.nacos.discovery.domain.SysUser;
import com.xingtuai.cloud.nacos.discovery.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
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

    @GetMapping("/{id}")
    public ResponseResult getUser(@PathVariable Long id) {

        log.info("接口进入   ---->   获取用户信息");
        log.info("请求参数：id = {}", id);

        SysUser user = userService.getUser(id);
        return ResponseResult.ok(user);
    }
}
