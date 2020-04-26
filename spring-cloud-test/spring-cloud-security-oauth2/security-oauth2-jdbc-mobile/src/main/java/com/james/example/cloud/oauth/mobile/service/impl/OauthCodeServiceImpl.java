package com.james.example.cloud.oauth.mobile.service.impl;

import com.james.example.cloud.oauth.mobile.mapper.OauthCodeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author James
 * @date 2020/4/23
 */
@Service
public class OauthCodeServiceImpl {

    @Resource
    private OauthCodeMapper oauthCodeMapper;

}
