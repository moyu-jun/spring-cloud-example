package com.james.example.cloud.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import javax.annotation.Resource;

/**
 * 认证服务器配置
 *
 * @author James
 * @date 2020/4/23
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 授权码模式
        // 1. 请求接口：http://localhost:8080/oauth/authorize?client_id=client&response_type=code
        // 2. 登录，登录成功后回调到 redirectUris 接口中并携带 code
        // 3. 再访问此接口 http://client:secret@localhost:8080/oauth/token，带着 grant_type 和 code

        clients.inMemory()
                .withClient("client")
                .secret(passwordEncoder.encode("secret"))
                .authorizedGrantTypes("authorization_code")
                .scopes("app")
                .redirectUris("http://www.jemgeek.com");
    }
}
