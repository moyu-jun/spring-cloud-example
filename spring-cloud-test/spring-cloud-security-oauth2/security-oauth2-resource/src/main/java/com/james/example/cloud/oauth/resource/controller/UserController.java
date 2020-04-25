package com.james.example.cloud.oauth.resource.controller;

import org.springframework.security.access.prepost.PreAuthorize;
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
        return "User is James " + userId;
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('sys:user:view')")
    public String list(){
        return "list user";
    }

    @GetMapping("/update")
    @PreAuthorize("hasAuthority('sys:user:edit')")
    public String update(){
        return "update user";
    }

    @GetMapping("/delete")
    @PreAuthorize("hasAuthority('sys:user:delete')")
    public String delete(){
        return "delete user";
    }

    @GetMapping("/delete2")
    @PreAuthorize("hasAuthority('sys:user:delete2')")
    public String delete2(){
        return "delete2 user";
    }
}
