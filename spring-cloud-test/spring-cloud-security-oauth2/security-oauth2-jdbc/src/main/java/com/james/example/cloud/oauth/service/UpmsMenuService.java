package com.james.example.cloud.oauth.service;

import com.james.example.cloud.oauth.domain.UpmsMenu;

import java.util.List;

/**
 * @author James
 * @date 2020/4/23
 */
public interface UpmsMenuService{

    /**
     * 查询菜单树,用户 ID 或用户名为空则查询全部
     *
     * @param username  用户名
     * @return {@link List <UpmsMenu>} 查询到的菜单列表
     */
    List<UpmsMenu> selectByUsername(String username);

    /**
     * 查询菜单树,用户 ID 或用户名为空则查询全部
     *
     * @param userId  用户名
     * @return {@link List <UpmsMenu>} 查询到的菜单列表
     */
    List<UpmsMenu> selectByUserId(Long userId);
}
