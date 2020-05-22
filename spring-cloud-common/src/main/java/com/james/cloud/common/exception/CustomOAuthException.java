package com.james.cloud.common.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.james.cloud.common.domain.ResponseCode;
import com.james.cloud.common.domain.ResponseResult;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author James
 * @date 2020/4/26
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@JsonSerialize(using = CustomOAuthExceptionSerializer.class)
public class CustomOAuthException extends OAuth2Exception{

    private ResponseResult result;

    public CustomOAuthException(OAuth2Exception oAuth2Exception){
        super(oAuth2Exception.getSummary(), oAuth2Exception);
        this.result = ResponseResult.error(ResponseCode.SYSTEM, oAuth2Exception);
    }
}
