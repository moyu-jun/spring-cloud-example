package com.james.example.cloud.oauth.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.james.example.cloud.oauth.mapper.UpmsUserMenuMapper;
import com.james.example.cloud.oauth.service.UpmsUserMenuService;
/**
 * @author James
 * @date 2020/4/23
 */
@Service
public class UpmsUserMenuServiceImpl implements UpmsUserMenuService{

    @Resource
    private UpmsUserMenuMapper upmsUserMenuMapper;

}
