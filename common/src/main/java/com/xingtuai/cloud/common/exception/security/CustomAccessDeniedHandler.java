package com.xingtuai.cloud.common.exception.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xingtuai.cloud.common.constants.CloudConstants;
import com.xingtuai.cloud.common.entity.ResponseCode;
import com.xingtuai.cloud.common.entity.ResponseResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  权限拒绝时统一返回
 *
 * @author James
 * @date 2020/9/24
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Resource
    ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding(CloudConstants.ENCODING_UTF_8);
        response.setContentType(CloudConstants.CONTENT_TYPE_JSON);

        response.getWriter().write(objectMapper.writeValueAsString(ResponseResult.error(ResponseCode.CLIENT_AUTH_ACCESS_DENIED, e.getMessage())));
    }
}
