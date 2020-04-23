package com.james.example.cloud.oauth.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.james.example.cloud.oauth.mapper.UpmsUserRoleMapper;
import com.james.example.cloud.oauth.service.UpmsUserRoleService;
/**
 * @author James
 * @date 2020/4/23
 */
@Service
public class UpmsUserRoleServiceImpl implements UpmsUserRoleService{

    @Resource
    private UpmsUserRoleMapper upmsUserRoleMapper;

}
