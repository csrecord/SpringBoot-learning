package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
//自动开启异步注解
@SpringBootApplication
//开启定时功能的注解
@EnableScheduling
public class Springboot09TaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springboot09TaskApplication.class, args);
    }
}
