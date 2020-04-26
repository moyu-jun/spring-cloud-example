package com.james.example.cloud.oauth.mobile.service.impl;

import com.james.example.cloud.oauth.mobile.mapper.ClientdetailsMapper;
import com.james.example.cloud.oauth.mobile.service.ClientdetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author James
 * @date 2020/4/23
 */
@Service
public class ClientdetailsServiceImpl implements ClientdetailsService {

    @Resource
    private ClientdetailsMapper clientdetailsMapper;

}
