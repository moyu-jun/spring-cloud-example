package com.james.cloud.common.exception;

import com.alibaba.fastjson.JSON;
import com.james.cloud.common.domain.Constants;
import com.james.cloud.common.domain.ResponseCode;
import com.james.cloud.common.domain.ResponseResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证权限入口 - 未登录的情况下访问所有接口都会拦截到此
 * 前后端分离情况下返回json格式数据
 *
 * @author James
 * @date 2020/5/19
 */
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setContentType(Constants.REQUEST_HEADER_CONTENT_TYPE_JSON);
        response.setCharacterEncoding(Constants.REQUEST_HEADER_ENCODING);

        // 未登录或 token 过期
        if (e != null) {
            response.getWriter().write(JSON.toJSONString(ResponseResult.error(ResponseCode.USER_AUTH, e.getMessage())));
        } else {
            response.getWriter().write(JSON.toJSONString(ResponseResult.error(ResponseCode.USER_AUTH_EXPIRED)));
        }
    }
}
