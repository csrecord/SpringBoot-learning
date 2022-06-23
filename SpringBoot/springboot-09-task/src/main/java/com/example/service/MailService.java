package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
@Service
public class MailService {
    JavaMailSenderImpl mailSender;
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
