package com.james.example.cloud.gateway.nacos.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义全局过滤器，进行权限认证
 * 需要实现 GlobalFilter 、Ordered 接口
 * <p>
 * Created by James on 2020/3/28.
 */
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    /**
     * 完成逻辑判断
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        // 如果 Token 为空则鉴权失败
        if (StringUtils.isBlank(token)) {
            // 鉴权失败
            System.out.println("鉴权失败，无权限");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        // 调用 chain.filter() 继续向下游执行
        return chain.filter(exchange);
    }

    // 获取优先级，数值越小，优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
