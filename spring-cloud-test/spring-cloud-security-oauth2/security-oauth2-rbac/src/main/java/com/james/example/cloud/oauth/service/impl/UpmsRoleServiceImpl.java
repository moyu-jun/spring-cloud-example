package com.james.example.cloud.oauth.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.james.example.cloud.oauth.mapper.UpmsRoleMapper;
import com.james.example.cloud.oauth.service.UpmsRoleService;
/**
 * @author James
 * @date 2020/4/23
 */
@Service
public class UpmsRoleServiceImpl implements UpmsRoleService{

    @Resource
    private UpmsRoleMapper upmsRoleMapper;

}
