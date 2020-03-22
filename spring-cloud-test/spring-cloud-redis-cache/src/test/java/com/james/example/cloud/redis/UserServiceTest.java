package com.james.example.cloud.redis;

import com.james.example.cloud.redis.domain.UpmsUser;
import com.james.example.cloud.redis.service.UpmsUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * Created by James on 2020/3/21.
 */
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UpmsUserService upmsUserService;

    @Test
    public void selectUserByName() {

        System.out.println("第一次获取");
        UpmsUser upmsUser1 = upmsUserService.select(1);

        if (null != upmsUser1) {
            System.out.println(upmsUser1.toString());
        } else {
            return;
        }

        System.out.println("第二次获取");
        UpmsUser upmsUser2 = upmsUserService.select(1);

        upmsUser2.setNickName("更新昵称");

        System.out.println("update result = " + upmsUserService.update(upmsUser2));

        System.out.println("第三次获取");
        UpmsUser upmsUser3 = upmsUserService.select(1);

        if (null != upmsUser3) {
            System.out.println(upmsUser3.toString());
        }
    }
}
