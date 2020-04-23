package com.james.example.cloud.oauth.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.james.example.cloud.oauth.mapper.ClientdetailsMapper;
import com.james.example.cloud.oauth.service.ClientdetailsService;
/**
 * @author James
 * @date 2020/4/23
 */
@Service
public class ClientdetailsServiceImpl implements ClientdetailsService{

    @Resource
    private ClientdetailsMapper clientdetailsMapper;

}
