package com.microservice.email.controller.sender;

import com.microservice.email.controller.enums.StatusEmailEnum;
import com.microservice.email.model.entity.Email;
import com.microservice.email.model.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailService emailService;

    public Email sendEmail(Email email) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            this.mailSender.send(message);
            email.setStatus(StatusEmailEnum.SENT);
        } catch (MailException e) {
            email.setStatus(StatusEmailEnum.ERROR);
            e.getCause();
        } finally {
            return this.emailService.save(email);
        }
    }

}
