package com.example.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
//这里使用了dubbo尽量不使用Service注解
//服务注册与发现
@Service
@Component
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "ok";
    }
}
