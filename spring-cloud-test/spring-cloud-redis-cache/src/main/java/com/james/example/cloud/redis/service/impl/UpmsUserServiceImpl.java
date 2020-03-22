package com.james.example.cloud.redis.service.impl;

import com.james.example.cloud.redis.domain.UpmsUser;
import com.james.example.cloud.redis.mapper.UpmsUserMapper;
import com.james.example.cloud.redis.service.UpmsUserService;
import com.james.example.cloud.redis.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by James on 2020/3/6.
 */
@Slf4j
@Service
public class UpmsUserServiceImpl implements UpmsUserService {

    @Resource
    private UpmsUserMapper upmsUserMapper;

    @Override
    @CacheEvict(value = "spring-cloud-redis-cache", key = "'selectUpmsUserByUsername_' + #id")
    public int updatePassword(Integer id, String encodePassword) {
        return 0;
    }

    @Override
    public int insert(UpmsUser record) {
        // 再判断 username 不存在(用户名需唯一)
        if (StringUtils.isNotBlank(record.getUsername()) && null == selectByName(record.getUsername())) {
            if (null != record.getId()) {
                record.setId(null);
            }
            return upmsUserMapper.insertSelective(record);
        } else {
            return 0;
        }
    }

    @Override
    @CacheEvict(value = "spring-cloud-redis-cache", key = "'selectUpmsUserByUserId_' + #id")
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public int delete(List<UpmsUser> records) {
        return 0;
    }

    @Override
    @CacheEvict(value = "spring-cloud-redis-cache", key = "'selectUpmsUserByUserId_' + #record.getId()")
    public int update(UpmsUser record) {
        // 不允许更新密码
        if (null != record.getPassword()) {
            record.setPassword(null);
        }
        return upmsUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Cacheable(value = "spring-cloud-redis-cache", key = "'selectUpmsUserByUserId_' + #id")
    public UpmsUser select(Integer id) {
        log.info("selectByName 走数据库");
        return upmsUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public UpmsUser selectByName(String username) {
        log.info("selectByName 走数据库");
        Example example = new Example(UpmsUser.class);
        example.createCriteria().andCondition("username=", username);

        return upmsUserMapper.selectOneByExample(example);
    }

    @Override
    @Cacheable(value = "spring-cloud-redis-cache", key = "'selectUpmsUserByUserId_' + #record.getId()")
    public UpmsUser select(UpmsUser record) {
        return upmsUserMapper.selectOne(record);
    }

    @Override
    public List<UpmsUser> selectAll(String label) {
        return null;
    }
}
