package com.xingtuai.cloud.nacos.config.service.impl;

import com.xingtuai.cloud.nacos.config.domain.SysUser;
import com.xingtuai.cloud.nacos.config.mapper.SysUserMapper;
import com.xingtuai.cloud.nacos.config.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 
 * @author James
 * @date 2020/9/25
 */
@Service
public class SysUserServiceImpl implements SysUserService{

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUser(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }
}
