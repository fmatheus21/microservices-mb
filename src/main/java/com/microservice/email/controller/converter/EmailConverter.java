package com.microservice.email.controller.converter;

import com.microservice.email.controller.dto.request.EmailDtoRequest;
import com.microservice.email.controller.dto.response.EmailDtoResponse;
import com.microservice.email.model.entity.Email;
import org.springframework.stereotype.Component;

@Component
public class EmailConverter {

    public Email converterRequestToEntity(EmailDtoRequest request) {
        return Email.builder()
                .ownerRef(request.getOwnerRef())
                .emailFrom(request.getEmailFrom())
                .emailTo(request.getEmailTo())
                .subject(request.getSubject())
                .text(request.getText())
                .build();
    }

    public EmailDtoResponse converterEntityToResponse(Email email) {
        return EmailDtoResponse.builder()
                .uuid(email.getId())
                .ownerRef(email.getOwnerRef())
                .emailFrom(email.getEmailFrom())
                .emailTo(email.getEmailTo())
                .subject(email.getSubject())
                .text(email.getText())
                .status(email.getStatus())
                .build();
    }

}
