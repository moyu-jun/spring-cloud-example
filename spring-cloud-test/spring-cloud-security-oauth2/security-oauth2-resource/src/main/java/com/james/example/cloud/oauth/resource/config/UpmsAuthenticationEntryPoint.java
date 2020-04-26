package com.james.example.cloud.oauth.resource.config;

import com.alibaba.fastjson.JSON;
import com.james.cloud.common.domain.ResponseResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证权限入口 - 未登录的情况下访问所有接口都会拦截到此
 * 前后端分离情况下返回json格式数据
 * <p>
 * Created by James on 2019/12/27.
 */
@Component
public class UpmsAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        // 未登录 或 token过期
        if (e != null) {
            System.out.println("");
            response.getWriter().write(JSON.toJSONString(ResponseResult.expired(e.getMessage())));
        } else {
            response.getWriter().write(JSON.toJSONString(ResponseResult.expired("Token 已过期")));
        }
    }
}
