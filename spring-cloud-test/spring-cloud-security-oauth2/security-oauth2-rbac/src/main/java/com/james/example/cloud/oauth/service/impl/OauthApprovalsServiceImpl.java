package com.james.example.cloud.oauth.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.james.example.cloud.oauth.mapper.OauthApprovalsMapper;
import com.james.example.cloud.oauth.service.OauthApprovalsService;
/**
 * @author James
 * @date 2020/4/23
 */
@Service
public class OauthApprovalsServiceImpl implements OauthApprovalsService{

    @Resource
    private OauthApprovalsMapper oauthApprovalsMapper;

}
