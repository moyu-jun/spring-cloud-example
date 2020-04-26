package com.james.example.cloud.oauth.mobile.service;

import com.james.example.cloud.oauth.domain.UpmsUser;

import java.util.Set;

/**
 * @author James
 * @date 2020/4/23
 */
public interface UpmsUserService{

    /**
     * 获取用户信息
     *
     * @param username {@link UpmsUser#getUsername()} 用户名
     * @return {@link UpmsUser}
     */
    UpmsUser selectByName(String username);

    /**
     * 查找用户的菜单权限标识集合
     *
     * @param username {@code String} 用户名
     * @return {@link Set <String>} 所有权限表示集合
     */
    Set<String> selectPermissions(String username);
}
