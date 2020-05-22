package com.james.cloud.common.exception;

import com.alibaba.fastjson.JSON;
import com.james.cloud.common.domain.Constants;
import com.james.cloud.common.domain.ResponseCode;
import com.james.cloud.common.domain.ResponseResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  权限拒绝时统一返回
 *
 * @author James
 * @date 2020/5/19
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding(Constants.REQUEST_HEADER_ENCODING);
        response.setContentType(Constants.REQUEST_HEADER_CONTENT_TYPE_JSON);

        response.getWriter().write(JSON.toJSONString(ResponseResult.error(ResponseCode.USER_AUTH_ACCESS_DENIED, e.getMessage())));
    }
}
