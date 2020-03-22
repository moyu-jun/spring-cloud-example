package com.james.example.cloud.redis.service;

import com.james.example.cloud.redis.domain.UpmsUser;

/**
 * 用户管理服务
 *
 * Created by James on 2020/3/6.
 */
public interface UpmsUserService extends BaseCurdService<UpmsUser> {

    /**
     * 获取用户信息
     *
     * @param username {@link UpmsUser#getUsername()} 用户名
     * @return {@link UpmsUser}
     */
    UpmsUser selectByName(String username);

    /**
     * 修改密码
     *
     * @param id {@code Integer} 用户 ID
     * @param encodePassword {@code String} 新的密码-密文，直接存储
     * @return {@code int} 大于 0 则表示更新成功
     */
    int updatePassword(Integer id, String encodePassword);

}
