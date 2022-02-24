package com.microservice.email.controller.resource;

import com.microservice.email.controller.dto.request.EmailDtoRequest;
import com.microservice.email.controller.dto.response.EmailDtoResponse;
import com.microservice.email.controller.rule.EmailRule;
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
    public ResponseEntity<EmailDtoResponse> send(@RequestBody @Valid EmailDtoRequest request) {
        return this.emailRule.send(request);
    }


}
