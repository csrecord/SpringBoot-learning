package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09TaskApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        //一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("夏天豪");
        mailMessage.setText("test");
        mailMessage.setTo("996615997@qq.com");
        mailMessage.setFrom("821132332@qq.com");
        mailSender.send(mailMessage);
    }

    @Test
    void contextLoads1() throws MessagingException {
        //复杂邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("夏天豪1");
        helper.setText("<p style='color:red'>mimeMessage helper测试，最美的祝福送给你。</p>",true);
        helper.addAttachment("1.txt", new File("C:\\Users\\Chenhf\\Desktop\\1.txt"));
        helper.setTo("996615997@qq.com");
        helper.setFrom("821132332@qq.com");
        mailSender.send(mimeMessage);
    }


    /**
     *
     * @param html
     * @param subject
     * @param text
     * @param destination
     * @param source
     * @throws MessagingException
     * @author Chenhf
     */

    public void sendMail(Boolean html, String subject, String text, String destination, String source) throws MessagingException {
        //复杂邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, html);
        helper.setSubject(subject);
        helper.setText(text,true);
        helper.addAttachment("1.txt", new File("C:\\Users\\Chenhf\\Desktop\\1.txt"));
        helper.setTo(destination);
        helper.setFrom(source);
        mailSender.send(mimeMessage);
    }
}
