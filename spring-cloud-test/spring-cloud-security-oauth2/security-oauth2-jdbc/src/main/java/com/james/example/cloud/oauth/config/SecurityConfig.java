package com.james.example.cloud.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * SpringSecurity 配置
 *
 * 注意：为了解决 OAuth 2 的跨域问题，必须使用 @Order(-1) 提升优先级
 * 参考：https://www.shuzhiduo.com/A/D854L3A25E/
 *
 * @author James
 * @date 2020/4/23
 */
@Configuration
@EnableWebSecurity
//@Order(-1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 访问权限认证异常处理
     */
//    @Resource
//    private UpmsAuthenticationEntryPoint upmsAuthenticationEntryPoint;

    /**
     * 自定义访问无权限接口时403响应内容
     */
//    @Resource
//    private UpmsAccessDeniedHandler upmsAccessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //不拦截 oauth 开放的资源
        http.authorizeRequests()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/oauth/logout").permitAll()
//                .antMatchers("/oauth/confirm_access").permitAll()
//                .antMatchers("/oauth/error").permitAll()
                .anyRequest().authenticated()
                .and()
                // 需要允许 /login 页面，否则授权码模式会 403 权限拒绝，因为无法登陆
                .formLogin().permitAll();
//        // 未登录认证异常
//        http.exceptionHandling().authenticationEntryPoint(upmsAuthenticationEntryPoint);
//        // 登录过后访问无权限的接口时自定义403响应内容
//        http.exceptionHandling().accessDeniedHandler(upmsAccessDeniedHandler);
    }
}
