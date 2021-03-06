package com.example.controller;

import com.example.service.AsyncService;
import com.example.service.MailService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;
    @RequestMapping("/hello")
    public String hello(){
        asyncService.hello();
        return "OK";
    }
}

