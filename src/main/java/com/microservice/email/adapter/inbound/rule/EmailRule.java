package com.microservice.email.adapter.inbound.rule;

import com.microservice.email.adapter.dto.request.EmailDtoRequest;
import com.microservice.email.adapter.inbound.converter.EmailInboundConverter;
import com.microservice.email.application.domain.Email;
import com.microservice.email.application.port.EmailServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EmailRule {

    @Autowired
    EmailServicePort emailServicePort;


    @Autowired
    private EmailInboundConverter emailConverter;

    public ResponseEntity<Email> send(EmailDtoRequest request) {
        var email = this.emailConverter.converterRequest(request);
        var emailSend = this.emailServicePort.sendEmail(email);
        return Objects.nonNull(emailSend) ? ResponseEntity.status(HttpStatus.CREATED).body(emailSend) : null;
    }


}
