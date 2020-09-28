package com.xingtuai.cloud.nacos.discovery.service;


import com.xingtuai.cloud.nacos.discovery.domain.SysUser;

/**
 * @author James
 * @date 2020/9/25
 */
public interface SysUserService {

    /**
     * 获取用户信息
     *
     * @param id 用户 ID
     * @return 用户信息
     */
    SysUser getUser(Long id);
}
