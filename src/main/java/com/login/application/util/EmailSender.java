package com.login.application.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendEmail(String toEmail){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("ashutoshnawale89@gmail.com");
        message.setTo(toEmail);
        message.setText("Welcome To Login App and Your Registration are Successfully Done...");
        message.setSubject("Registration Successfully Done...");
        javaMailSender.send(message);
        System.out.println("Mail Sent Successfully.......");
    }
}
