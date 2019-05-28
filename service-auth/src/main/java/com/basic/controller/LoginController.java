package com.basic.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 登录控制器
 * @Author: wisdomwang
 * @Date: 2019-05-23 14:40
 **/
@RestController
public class LoginController {
    @Value("${auth}")
    private String auth;

    @GetMapping("/login")
    public String login(){
        return auth;
    }
}
