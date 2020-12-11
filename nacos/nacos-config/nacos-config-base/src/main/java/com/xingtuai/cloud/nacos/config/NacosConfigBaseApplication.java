package com.xingtuai.cloud.nacos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author James
 * @date 2020/9/24
 */
@SpringBootApplication
@RestController
@RefreshScope
public class NacosConfigBaseApplication {

    @Value("${user.name}")
    private String userName;

    @Value("${user.age}")
    private int userAge;

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigBaseApplication.class, args);

//        ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosConfigBaseApplication.class, args);
//        while (true) {
//            // 当动态配置刷新时，会更新到 Enviroment 中，因此这里每隔一秒中从 Enviroment 中获取配置
//            String userName = applicationContext.getEnvironment().getProperty("user.name");
//            String userAge = applicationContext.getEnvironment().getProperty("user.age");
//            String active = applicationContext.getEnvironment().getProperty("profiles.active");
//            System.err.println("profiles active: " + active + "; user name :" + userName + "; user age: " + userAge);
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    @PostConstruct
    public void init(){
        System.out.printf("[init] user name : %s, age: %d%n", userName, userAge);
    }

    @PreDestroy
    public void destroy(){
        System.out.printf("[destroy] user name : %s, age: %d%n", userName, userAge);
    }

    @RequestMapping("/user")
    public String user(){
        return String.format("[HTTP] user name : %s, age: %d%n", userName, userAge);
    }

}
