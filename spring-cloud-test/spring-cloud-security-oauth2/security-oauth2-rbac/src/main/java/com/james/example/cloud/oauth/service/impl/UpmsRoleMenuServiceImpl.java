package com.james.example.cloud.oauth.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.james.example.cloud.oauth.mapper.UpmsRoleMenuMapper;
import com.james.example.cloud.oauth.service.UpmsRoleMenuService;
/**
 * @author James
 * @date 2020/4/23
 */
@Service
public class UpmsRoleMenuServiceImpl implements UpmsRoleMenuService{

    @Resource
    private UpmsRoleMenuMapper upmsRoleMenuMapper;

}
