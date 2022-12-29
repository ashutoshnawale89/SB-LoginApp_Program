package com.login.application.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
@Configuration
public class EventMailSender {
    @Autowired
    EmailSender senderJava;
   // @EventListener(ApplicationReadyEvent.class)
    public void sendMail(String email){
        senderJava.sendEmail(email);
    }
}
