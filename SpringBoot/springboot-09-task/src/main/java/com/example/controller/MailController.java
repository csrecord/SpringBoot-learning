package com.example.controller;

import com.example.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class MailController {
    @Autowired
    MailService mailService;

    /**
     *
     * @return
     * @throws MessagingException
     */
    @RequestMapping("/test")
    public String mailTest() throws MessagingException {
        mailService.sendMail(true, "asd", "asd", "821132332@qq.com", "821132332@qq.com");
        return "ok";
    }
}
