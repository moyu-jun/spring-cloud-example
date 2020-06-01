package com.james.example.rabbit.controller;
import com.james.example.rabbit.domain.SystemLog;
import com.james.example.rabbit.sender.LogSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author James
 * @date 2020/6/1
 */
@RestController
@RequestMapping
public class LogController {

    @Resource
    private LogSender logSender;

    @GetMapping("/log")
    public String addLog(@RequestParam String message){

        SystemLog systemLog = new SystemLog();
        systemLog.setUsername("James");
        systemLog.setMessage(message);
        systemLog.setCreateTime(LocalDateTime.now());

        logSender.sendLog(systemLog);

        return "日志发送成功";
    }

}
