package com.james.example.rabbit.receiver;

import com.alibaba.fastjson.JSONObject;
import com.james.example.rabbit.domain.SystemLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author James
 * @date 2020/5/29
 */
@Slf4j
@Component
public class LogReceiver {

    @RabbitListener(queues = "log_queue")
    public void processLog(String message){
        log.info("Receiver ==================: {}", message);

        try{
            SystemLog systemLog = JSONObject.parseObject(message, SystemLog.class);
            log.info("Receiver ==================: {}", systemLog.toString());
            // TODO 存储
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
