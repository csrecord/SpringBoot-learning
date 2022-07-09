package com.chenhf.rabbitmq;

import com.chenhf.pojo.SeckillMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: TODO
 * @className: MQSender
 * @author: Chenhf
 * @date: 2022/7/9 16:51
 * @version: 1.0
 */
@Service
@Slf4j
public class MQSender {

    //rabbit发消息用的模板
    @Autowired
    RabbitTemplate rabbitTemplate;

    //发送秒杀信息
    public void sendSeckillMessage(String message){
        log.info("发送消息:"+message);
        rabbitTemplate.convertAndSend("seckillExchange","seckill.message",message);
    }
}
