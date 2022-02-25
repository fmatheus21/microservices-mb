package com.microservice.email.adapter.inbound.resource;

import com.microservice.email.adapter.dto.request.EmailDtoRequest;
import com.microservice.email.adapter.inbound.rule.EmailRule;
import com.microservice.email.application.domain.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/mail")
public class EmailResource {

    @Autowired
    private EmailRule emailRule;

    @PostMapping
    public ResponseEntity<Email> send(@RequestBody @Valid EmailDtoRequest request) {
        return this.emailRule.send(request);
    }


}
