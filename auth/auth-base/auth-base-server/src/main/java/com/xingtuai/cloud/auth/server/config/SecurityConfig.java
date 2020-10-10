package com.xingtuai.cloud.auth.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SpringSecurity 配置
 * <p>
 * 注意：为了解决 OAuth 2 的跨域问题，必须使用 @Order(-1) 提升优先级
 * 参考：https://www.shuzhiduo.com/A/D854L3A25E/
 *
 * @author James
 * @date 2020/9/7
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
