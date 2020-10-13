package com.xingtuai.cloud.auth.server.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.xingtuai.cloud.auth.server.mapper.SysUserMapper;
import com.xingtuai.cloud.auth.server.service.SysUserService;
/**
 * 
 * @author James
 * @date 2020/10/10
 */
@Service
public class SysUserServiceImpl implements SysUserService{

    @Resource
    private SysUserMapper sysUserMapper;

}
