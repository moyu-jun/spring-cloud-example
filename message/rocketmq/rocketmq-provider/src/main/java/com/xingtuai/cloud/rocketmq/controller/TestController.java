package com.xingtuai.cloud.rocketmq.controller;

import com.xingtuai.cloud.rocketmq.domain.User;
import com.xingtuai.cloud.rocketmq.service.SenderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author James
 * @date 2020/12/15
 */
@RestController
@RequestMapping
public class TestController {

    @Resource
    SenderService senderService;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String send(String message){
        senderService.send(message);
        return "字符串消息发送成功";
    }

    @RequestMapping(value = "/send/tag", method = RequestMethod.GET)
    public String send(String message, String tag){
        senderService.sendWithTags(message, "testTag");
        return "带Tag的消息发送成功";
    }

    @RequestMapping(value = "/send/object", method = RequestMethod.GET)
    public String sendObject(String name, Integer age){
        senderService.sendObject(new User(name, age), "tagObj");
        return "对象消息发送成功";
    }
}
