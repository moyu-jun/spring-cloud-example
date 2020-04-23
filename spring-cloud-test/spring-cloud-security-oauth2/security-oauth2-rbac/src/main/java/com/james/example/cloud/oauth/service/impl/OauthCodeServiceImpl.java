package com.james.example.cloud.oauth.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.james.example.cloud.oauth.mapper.OauthCodeMapper;
import com.james.example.cloud.oauth.service.OauthCodeService;
/**
 * @author James
 * @date 2020/4/23
 */
@Service
public class OauthCodeServiceImpl implements OauthCodeService{

    @Resource
    private OauthCodeMapper oauthCodeMapper;

}
