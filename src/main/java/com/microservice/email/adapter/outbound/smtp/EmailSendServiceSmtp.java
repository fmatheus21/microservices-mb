package com.microservice.email.adapter.outbound.smtp;

import com.microservice.email.application.domain.Email;
import com.microservice.email.application.port.EmailSendServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSendServiceSmtp implements EmailSendServicePort {

    @Autowired
    JavaMailSender mailSender;


    @Override
    public void sendEmailSmtp(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email.getEmailFrom());
        message.setTo(email.getEmailTo());
        message.setSubject(email.getSubject());
        message.setText(email.getText());
        this.mailSender.send(message);
    }
}
