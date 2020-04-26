package com.james.example.cloud.oauth.service.impl;

import com.james.example.cloud.oauth.domain.UpmsMenu;
import com.james.example.cloud.oauth.domain.UpmsUser;
import com.james.example.cloud.oauth.service.UpmsMenuService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.james.example.cloud.oauth.mapper.UpmsUserMapper;
import com.james.example.cloud.oauth.service.UpmsUserService;
import tk.mybatis.mapper.entity.Example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author James
 * @date 2020/4/23
 */
@Service
public class UpmsUserServiceImpl implements UpmsUserService{

    @Resource
    private UpmsUserMapper upmsUserMapper;

    @Resource
    private UpmsMenuService upmsMenuService;

    @Override
    public UpmsUser selectByName(String username) {
        Example example = new Example(UpmsUser.class);
        example.createCriteria().andCondition("username=", username);

        UpmsUser user = upmsUserMapper.selectOneByExample(example);

        if (null != user) {
//            List<UpmsUserRole> userRoles = selectUserRoles(user.getId());
//            user.setUserRoles(userRoles);
//            user.setRoleNames(getRoleNames(userRoles));
        }
        return user;
    }

    @Override
    public Set<String> selectPermissions(String username) {
        Set<String> permissions = new HashSet<>();
        List<UpmsMenu> upmsMenus = upmsMenuService.selectByUsername(username);
        for (UpmsMenu upmsMenu : upmsMenus) {
            if (StringUtils.isNotBlank(upmsMenu.getPermissions())) {
                permissions.add(upmsMenu.getPermissions());
            }
        }
        return permissions;
    }

}
