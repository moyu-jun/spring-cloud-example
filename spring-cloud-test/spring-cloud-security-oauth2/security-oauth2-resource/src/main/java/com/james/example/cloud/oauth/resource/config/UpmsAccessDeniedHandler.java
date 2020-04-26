package com.james.example.cloud.oauth.resource.config;

import com.alibaba.fastjson.JSON;
import com.james.cloud.common.domain.ResponseResult;
import com.james.cloud.common.domain.ResultCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author James
 * @date 2020/4/26
 */
@Component
public class UpmsAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");

        httpServletResponse.getWriter().write(JSON.toJSONString(ResponseResult.fail(ResultCode.UNAUTHORIZED.getCode(), e.getMessage())));
    }
}
