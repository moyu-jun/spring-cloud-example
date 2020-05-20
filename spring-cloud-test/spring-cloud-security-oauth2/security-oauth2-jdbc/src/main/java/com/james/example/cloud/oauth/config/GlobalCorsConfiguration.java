package com.james.example.cloud.oauth.config;

/**
 * 解决跨域问题配置
 * 同时，SecurityConfig 类中需要提升优先级
 *
 * 如果网关配置了跨域，则其他所有地方的跨域都不需要配置
 *
 * 参考：https://www.shuzhiduo.com/A/D854L3A25E/
 *
 * @author James
 * @date 2020/5/20
 */
//@Configuration
//public class GlobalCorsConfiguration {
//    @Bean
//    public CorsFilter corsFilter() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowCredentials(true);
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedMethod("*");
//        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//        return new CorsFilter(urlBasedCorsConfigurationSource);
//    }
//}
