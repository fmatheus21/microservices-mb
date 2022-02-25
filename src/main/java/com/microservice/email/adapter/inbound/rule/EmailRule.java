package com.microservice.email.adapter.inbound.rule;

import com.microservice.email.adapter.dto.request.EmailDtoRequest;
import com.microservice.email.adapter.inbound.converter.EmailInboundConverter;
import com.microservice.email.application.domain.Email;
import com.microservice.email.application.domain.PageInfo;
import com.microservice.email.application.port.EmailServicePort;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

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

    public ResponseEntity<Page<Email>> findAll(Pageable pageable) {
        PageInfo pageInfo = new PageInfo();
        BeanUtils.copyProperties(pageable, pageInfo);
        List<Email> emailList = emailServicePort.findAll(pageInfo);
        return new ResponseEntity<>(new PageImpl<>(emailList, pageable, emailList.size()), HttpStatus.OK);
    }

    public ResponseEntity<Object> findById(UUID uuid) {
        Optional<Email> email = emailServicePort.findById(uuid);
        return email.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(email) : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registro não encontrado.");
    }

}
