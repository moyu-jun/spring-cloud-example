package com.james.example.cloud.oauth.resource.config;

import com.james.cloud.common.exception.CustomWebResponseExceptionTranslator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

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
