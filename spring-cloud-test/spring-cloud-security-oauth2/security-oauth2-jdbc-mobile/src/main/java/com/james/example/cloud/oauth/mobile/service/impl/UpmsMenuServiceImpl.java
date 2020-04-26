package com.james.example.cloud.oauth.mobile.service.impl;

import com.james.example.cloud.oauth.domain.UpmsMenu;
import com.james.example.cloud.oauth.mapper.UpmsMenuMapper;
import com.james.example.cloud.oauth.service.UpmsMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author James
 * @date 2020/4/23
 */
@Service
public class UpmsMenuServiceImpl implements UpmsMenuService{

    @Resource
    private UpmsMenuMapper upmsMenuMapper;

    @Override
    public List<UpmsMenu> selectByUsername(String username) {
        if (null == username || "".equals(username)) {
            return upmsMenuMapper.selectAll();
        }
        return upmsMenuMapper.selectByUsername(username);
    }

    @Override
    public List<UpmsMenu> selectByUserId(Long userId) {
        if (null == userId) {
            return upmsMenuMapper.selectAll();
        }
        return upmsMenuMapper.selectByUserId(userId);
    }
}
