package com.james.example.cloud.oauth.mapper;

import com.james.example.cloud.oauth.domain.UpmsMenu;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

/**
 * @author James
 * @date 2020/4/23
 */
public interface UpmsMenuMapper extends MyMapper<UpmsMenu> {
    /**
     * 通过用户名获取菜单列表
     *
     * @param username  用户名
     * @return
     */
    List<UpmsMenu> selectByUsername(String username);

    /**
     * 通过用户 Id 获取菜单列表
     *
     * @param userId  用户 Id
     * @return
     */
    List<UpmsMenu> selectByUserId(Long userId);
}