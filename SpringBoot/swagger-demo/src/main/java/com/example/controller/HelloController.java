package com.example.controller;

import com.example.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;

@RestController
public class HelloController {
    //默认请求
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    //只要接口中返回值存在实体类
    @PostMapping("/user")
    public User user(){
        return new User();
    }
}
