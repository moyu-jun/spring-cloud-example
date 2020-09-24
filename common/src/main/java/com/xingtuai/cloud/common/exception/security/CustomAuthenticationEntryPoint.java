package com.xingtuai.cloud.common.exception.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xingtuai.cloud.common.constants.CloudConstants;
import com.xingtuai.cloud.common.entity.ResponseCode;
import com.xingtuai.cloud.common.entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证权限入口 - 未登录的情况下访问所有接口都会拦截到此
 * 前后端分离情况下返回json格式数据
 *
 * @author James
 * @date 2020/9/24
 */
@Slf4j
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Resource
    ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setCharacterEncoding(CloudConstants.ENCODING_UTF_8);
        response.setContentType(CloudConstants.CONTENT_TYPE_JSON);

        log.debug("AuthenticationException = ", e);

        // 未登录或 token 过期
        if (e != null) {
            response.getWriter().write(objectMapper.writeValueAsString(ResponseResult.error(ResponseCode.CLIENT_AUTH, e.getMessage())));
        } else {
            response.getWriter().write(objectMapper.writeValueAsString(ResponseResult.error(ResponseCode.CLIENT_AUTH_EXPIRED)));
        }
    }
}
