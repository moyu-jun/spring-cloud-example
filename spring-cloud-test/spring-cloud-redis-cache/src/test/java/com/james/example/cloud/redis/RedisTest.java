package com.james.example.cloud.redis;

import com.james.example.cloud.redis.config.RedisHelper;
import com.james.example.cloud.redis.domain.UpmsUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 2020/1/3.
 */
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisHelper redisHelper;

    @Test
    public void redisBaseTest() {

        redisHelper.set("james", "token-james", 100);
        System.out.println("expire time = " + redisHelper.getExpire("james"));

        if (null != (String) redisHelper.get("james")) {
            System.out.println("james != null; james value = " + redisHelper.get("james"));
        } else {
            System.out.println("james == null");
        }
    }

    /**
     * Redis 存储读取对象测试
     */
    @Test
    public void redisObjectTest() {
        UpmsUser upmsUser = new UpmsUser();
        upmsUser.setId(2);
        upmsUser.setUsername("james");
        upmsUser.setPassword("James");
        upmsUser.setNickName("James");
        upmsUser.setMobile("13764297441");

        redisHelper.set(upmsUser.getUsername(), upmsUser, 100);

        UpmsUser user = (UpmsUser) redisHelper.get(upmsUser.getUsername());

        if (user != null) {
            System.out.println(user.toString());
        }
    }

    /**
     * Redis 存储读取对象列表测试
     */
    @Test
    public void redisObjectListTest() {

        List<UpmsUser> upmsUsers = new ArrayList<>();

        UpmsUser upmsUser1 = new UpmsUser();
        upmsUser1.setId(2);
        upmsUser1.setUsername("james");
        upmsUser1.setPassword("James");
        upmsUser1.setNickName("James");
        upmsUser1.setMobile("13764297441");

        UpmsUser upmsUser2 = new UpmsUser();
        upmsUser2.setId(3);
        upmsUser2.setUsername("jim");
        upmsUser2.setPassword("jim");
        upmsUser2.setNickName("jim");
        upmsUser2.setMobile("13764297441");

        upmsUsers.add(upmsUser1);
        upmsUsers.add(upmsUser2);

        redisHelper.set("UserList", upmsUsers, 100);

        List<UpmsUser> users = (List<UpmsUser>) redisHelper.get("UserList");

        if (users != null && users.size() > 0) {
            System.out.println(users.toString());
        }
    }

    /**
     * Redis 删除数据测试
     */
    @Test
    public void redisDeleteTest() {

        redisHelper.del("james", "UserList");
    }
}
