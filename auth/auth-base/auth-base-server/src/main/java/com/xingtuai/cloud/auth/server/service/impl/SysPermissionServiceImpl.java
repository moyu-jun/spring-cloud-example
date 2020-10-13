package com.xingtuai.cloud.auth.server.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.xingtuai.cloud.auth.server.mapper.SysPermissionMapper;
import com.xingtuai.cloud.auth.server.service.SysPermissionService;
/**
 * 
 * @author James
 * @date 2020/10/10
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService{

    @Resource
    private SysPermissionMapper sysPermissionMapper;

}
