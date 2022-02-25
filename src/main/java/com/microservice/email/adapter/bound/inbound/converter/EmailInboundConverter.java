package com.microservice.email.adapter.bound.inbound.converter;

import com.microservice.email.adapter.dto.request.EmailDtoRequest;
import com.microservice.email.application.domain.Email;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EmailInboundConverter {

    public Email converterRequest(EmailDtoRequest request) {
        var email = new Email();
        BeanUtils.copyProperties(request, email);
        return email;
    }


}
