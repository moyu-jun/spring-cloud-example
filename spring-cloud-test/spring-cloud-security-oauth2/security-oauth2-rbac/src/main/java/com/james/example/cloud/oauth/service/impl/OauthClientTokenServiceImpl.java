package com.james.example.cloud.oauth.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.james.example.cloud.oauth.mapper.OauthClientTokenMapper;
import com.james.example.cloud.oauth.service.OauthClientTokenService;
/**
 * @author James
 * @date 2020/4/23
 */
@Service
public class OauthClientTokenServiceImpl implements OauthClientTokenService{

    @Resource
    private OauthClientTokenMapper oauthClientTokenMapper;

}
