package com.james.example.cloud.oauth.resource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author James
 * @date 2020/4/24
 */
@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping("/{userId}")
    public String getUser(@PathVariable("userId") Integer userId){
        return "User is James";
    }
}
