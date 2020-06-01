package com.james.example.rabbit.sender;

import com.alibaba.fastjson.JSONObject;
import com.james.example.rabbit.domain.SystemLog;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author James
 * @date 2020/5/29
 */
@Component
public class LogSender {

    @Resource
    private AmqpTemplate rabbitTemplate;

    public void sendLog(SystemLog systemLog){
        this.rabbitTemplate.convertAndSend("log_queue", JSONObject.toJSONString(systemLog));
    }
}
