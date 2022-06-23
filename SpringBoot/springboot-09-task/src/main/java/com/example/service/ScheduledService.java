package com.example.service;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//定时任务：在方法上面增加@Scheduled注解即可
@Service
public class ScheduledService {
    //在一个特定的时间执行方法
    //cron
    @Scheduled(cron = "0 28 15 * * ?")
    public void hello() {
        System.out.println("hello,你被执行了~");
    }
}

