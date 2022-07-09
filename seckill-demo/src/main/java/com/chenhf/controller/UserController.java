package com.chenhf.controller;


import com.chenhf.pojo.User;
import com.chenhf.rabbitmq.MQSender;
import com.chenhf.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenhf
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    MQSender mqSender;
    /**
     * @description 用来测试用户信息
     * @param user
     * @return RespBean
     * @author Chenhf
     * @date 2022/7/7 15:58
     */
    @RequestMapping("/info")
    public RespBean info(User user){
        return RespBean.success(user);
    }

    //mq测试消息发送
    @RequestMapping("/mq")
    @ResponseBody
    public void mq(){
        mqSender.send("hello");
    }

    //mq测试消息发送
    @RequestMapping("/mq/fanout")
    @ResponseBody
    public void mq01(){
        mqSender.send("fanout");
    }

    //mq测试消息发送
    @RequestMapping("/mq/direct01")
    @ResponseBody
    public void mq02(){
        mqSender.send01("direct-red");
    }

    //mq测试消息发送
    @RequestMapping("/mq/direct02")
    @ResponseBody
    public void mq03(){
        mqSender.send02("direct-green");
    }

    //mq测试消息发送
    @RequestMapping("/mq/topic01")
    @ResponseBody
    public void mq04(){
        mqSender.send03("hello01");
    }

    //mq测试消息发送
    @RequestMapping("/mq/topic02")
    @ResponseBody
    public void mq05(){
        mqSender.send04("hello01&02");
    }

}
