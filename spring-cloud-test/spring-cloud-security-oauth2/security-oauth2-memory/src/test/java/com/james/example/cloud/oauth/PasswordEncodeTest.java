package com.james.example.cloud.oauth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author James
 * @date 2020/4/23
 */
public class PasswordEncodeTest {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("secret"));
    }
}
