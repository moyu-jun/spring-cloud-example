package com.james.example.cloud.oauth.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.james.example.cloud.oauth.mapper.OauthRefreshTokenMapper;
import com.james.example.cloud.oauth.service.OauthRefreshTokenService;
/**
 * @author James
 * @date 2020/4/23
 */
@Service
public class OauthRefreshTokenServiceImpl implements OauthRefreshTokenService{

    @Resource
    private OauthRefreshTokenMapper oauthRefreshTokenMapper;

}
