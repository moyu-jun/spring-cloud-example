package com.james.example.cloud.oauth.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.james.example.cloud.oauth.mapper.OauthAccessTokenMapper;
import com.james.example.cloud.oauth.service.OauthAccessTokenService;
/**
 * @author James
 * @date 2020/4/23
 */
@Service
public class OauthAccessTokenServiceImpl implements OauthAccessTokenService{

    @Resource
    private OauthAccessTokenMapper oauthAccessTokenMapper;

}
