package com.james.example.cloud.oauth.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.james.example.cloud.oauth.mapper.OauthClientDetailsMapper;
import com.james.example.cloud.oauth.service.OauthClientDetailsService;
/**
 * @author James
 * @date 2020/4/23
 */
@Service
public class OauthClientDetailsServiceImpl implements OauthClientDetailsService{

    @Resource
    private OauthClientDetailsMapper oauthClientDetailsMapper;

}
