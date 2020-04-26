package com.james.example.cloud.oauth.mobile.service.impl;

import com.james.example.cloud.oauth.mobile.mapper.OauthClientDetailsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author James
 * @date 2020/4/23
 */
@Service
public class OauthClientDetailsServiceImpl {

    @Resource
    private OauthClientDetailsMapper oauthClientDetailsMapper;

}
