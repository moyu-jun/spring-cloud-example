package com.james.example.cloud.oauth.mobile.service.impl;

import com.james.example.cloud.oauth.mobile.mapper.OauthAccessTokenMapper;
import com.james.example.cloud.oauth.mobile.service.OauthAccessTokenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author James
 * @date 2020/4/23
 */
@Service
public class OauthAccessTokenServiceImpl implements OauthAccessTokenService {

    @Resource
    private OauthAccessTokenMapper oauthAccessTokenMapper;

}
