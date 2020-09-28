package com.xingtuai.cloud.nacos.discovery.service.impl;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xingtuai.cloud.nacos.discovery.domain.SysUser;
import com.xingtuai.cloud.nacos.discovery.mapper.SysUserMapper;
import com.xingtuai.cloud.nacos.discovery.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 
 * @author James
 * @date 2020/9/25
 */
@Slf4j
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    @SentinelResource(value = "UserService.getUser", blockHandler = "getUserBlockHandler")
    public SysUser getUser(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 限流处理
     * 返回参数与原方法一致
     * 入参也需一致，但是需要加上 BlockException e 参数
     *
     * 同时需要加入 SentinelAspectConfig 切面
     *
     * @return
     */
    public SysUser getUserBlockHandler(Long id, BlockException e){
        log.info("method getUser() 被限流, id: {}", id);
        return null;
    }
}
