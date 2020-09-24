package com.xingtuai.cloud.common.exception.security;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xingtuai.cloud.common.entity.ResponseCode;
import com.xingtuai.cloud.common.entity.ResponseResult;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.*;

/**
 * @author James
 * @date 2020/9/24
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@JsonSerialize(using = CustomAuthExceptionSerializer.class)
public class CustomAuthException extends OAuth2Exception {

    private ResponseResult result;

    public CustomAuthException(OAuth2Exception oAuth2Exception) {
        super(oAuth2Exception.getSummary(), oAuth2Exception);

        if (oAuth2Exception instanceof InvalidClientException) {
            this.result = ResponseResult.error(ResponseCode.CLIENT_AUTH_CLIENT_INVALID);
        } else if (oAuth2Exception instanceof UnauthorizedClientException) {
            this.result = ResponseResult.error(ResponseCode.CLIENT_AUTH_CLIENT_UNAUTHORIZED);
        } else if (oAuth2Exception instanceof InvalidGrantException) {
            this.result = ResponseResult.error(ResponseCode.CLIENT_AUTH_GRANT_INVALID);
        } else if (oAuth2Exception instanceof InvalidScopeException) {
            this.result = ResponseResult.error(ResponseCode.CLIENT_AUTH_SCOPE_INVALID);
        } else if (oAuth2Exception instanceof InvalidTokenException) {
            this.result = ResponseResult.error(ResponseCode.CLIENT_AUTH_TOKEN_INVALID);
        } else if (oAuth2Exception instanceof InvalidRequestException) {
            this.result = ResponseResult.error(ResponseCode.CLIENT_AUTH_REQUEST_INVALID);
        } else if (oAuth2Exception instanceof RedirectMismatchException) {
            this.result = ResponseResult.error(ResponseCode.CLIENT_AUTH_REDIRECT_MISMATCH);
        } else if (oAuth2Exception instanceof UnsupportedGrantTypeException) {
            this.result = ResponseResult.error(ResponseCode.CLIENT_AUTH_GRANT_TYPE_UNSUPPORTED);
        } else if (oAuth2Exception instanceof UnsupportedResponseTypeException) {
            this.result = ResponseResult.error(ResponseCode.CLIENT_AUTH_RESPONSE_TYPE_UNSUPPORTED);
        } else if (oAuth2Exception instanceof UserDeniedAuthorizationException) {
            this.result = ResponseResult.error(ResponseCode.CLIENT_AUTH_ACCESS_DENIED);
        } else {
            this.result = ResponseResult.error(ResponseCode.CLIENT_AUTH);
        }

        this.result.setData(oAuth2Exception);
    }
}
