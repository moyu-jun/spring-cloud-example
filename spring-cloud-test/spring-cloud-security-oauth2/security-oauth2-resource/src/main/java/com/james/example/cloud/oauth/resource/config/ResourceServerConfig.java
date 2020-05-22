package com.james.example.cloud.oauth.resource.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import javax.annotation.Resource;

/**
 * @author James
 * @date 2020/4/24
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Resource
    private UpmsAccessDeniedHandler upmsAccessDeniedHandler;

    @Resource
    private UpmsAuthenticationEntryPoint upmsAuthenticationEntryPoint;

    /**
     * 自定义OAuth2异常处理
     *
     * @return CustomWebResponseExceptionTranslator
     */
//    @Bean
//    public WebResponseExceptionTranslator<OAuth2Exception> customExceptionTranslator() {
//        return new CustomWebResponseExceptionTranslator();
//    }


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.authenticationEntryPoint(upmsAuthenticationEntryPoint)
                .accessDeniedHandler(upmsAccessDeniedHandler);

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        //不拦截 oauth 开放的资源
        http.authorizeRequests()
//                .antMatchers("/list").permitAll()
//                .antMatchers("/update").permitAll()
//                .antMatchers("/update/").permitAll()
                .antMatchers("/test/**").permitAll()
                .anyRequest().authenticated();
    }
}
