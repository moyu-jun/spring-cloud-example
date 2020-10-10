package com.xingtuai.cloud.auth.server.config;

import com.xingtuai.cloud.common.exception.security.CustomAccessDeniedHandler;
import com.xingtuai.cloud.common.exception.security.CustomAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 添加资源服务器配置，以拦截一些未认证的消息
 * <p>
 * SecurityConfig 配置 CustomAccessDeniedHandler 及 CustomAuthenticationEntryPoint 不生效
 *
 * @author James
 * @date 2020/9/7
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    /**
     * 自定义访问无权限接口时403响应内容
     */
    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    /**
     * 访问权限认证异常处理
     */
    @Bean
    public CustomAuthenticationEntryPoint customAuthenticationEntryPoint() {
        return new CustomAuthenticationEntryPoint();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.authenticationEntryPoint(customAuthenticationEntryPoint())
                .accessDeniedHandler(customAccessDeniedHandler());
    }

    /**
     * 此方法在拥有 ResourceServerConfig 时，放在 SecurityConfig 中不生效
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable();

        http.authorizeRequests()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/oauth/login").permitAll()
                .antMatchers("/oauth/logout").permitAll()
                .antMatchers("/oauth/code").permitAll()
                .anyRequest().authenticated()
                .and()
                // 需要允许 /login 页面，否则授权码模式会 403 权限拒绝，因为无法登陆
                .formLogin().permitAll();
    }
}
