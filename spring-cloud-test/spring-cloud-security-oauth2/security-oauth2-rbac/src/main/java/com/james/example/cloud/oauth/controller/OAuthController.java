package com.james.example.cloud.oauth.controller;

import org.springframework.security.core.token.TokenService;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author James
 * @date 2020/4/25
 */
@RestController
@RequestMapping("oauth")
public class OAuthController {

    @Resource
    private ConsumerTokenServices tokenService;

    @GetMapping("/logout")
    public String logout(@RequestHeader("Authorization") String token) {

        token = token.replace("Bearer ", "");
        System.out.println("token = " + token);

        boolean result = tokenService.revokeToken(token);
        if (result) {
            System.out.println("退出登录成功，清除 Token");
        } else {
            System.out.println("退出登录失败");
        }
        return "退出登录成功";
    }
}
