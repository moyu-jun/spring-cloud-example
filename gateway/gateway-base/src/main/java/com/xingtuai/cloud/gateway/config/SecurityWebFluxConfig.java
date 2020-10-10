package com.xingtuai.cloud.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


/**
 * 解决问题： CSRF Token has been associated to this client
 *
 * @author James
 * @date 2020/9/9
 */
@EnableWebFluxSecurity
public class SecurityWebFluxConfig {
    @Bean
    SecurityWebFilterChain webFluxSecurityFilterChain(ServerHttpSecurity http) throws Exception {

        http.csrf().disable();

        http.formLogin().disable();

        return http.build();
    }
}
