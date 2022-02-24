package com.microservice.email.controller.rule;

import com.microservice.email.controller.converter.EmailConverter;
import com.microservice.email.controller.dto.request.EmailDtoRequest;
import com.microservice.email.controller.dto.response.EmailDtoResponse;
import com.microservice.email.controller.sender.EmailSender;
import com.microservice.email.model.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EmailRule {

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailConverter emailConverter;

    public ResponseEntity<EmailDtoResponse> send(EmailDtoRequest request) {
        var email = this.emailConverter.converterRequestToEntity(request);
        var emailSend = this.emailSender.sendEmail(email);
        return Objects.nonNull(emailSend) ? ResponseEntity.status(HttpStatus.CREATED).body(this.emailConverter.converterEntityToResponse(emailSend)) : null;
    }


}
