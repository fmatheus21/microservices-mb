package com.microservice.email.application.port;

import com.microservice.email.application.domain.Email;

public interface EmailSendServicePort {

    void sendEmailSmtp(Email email);
}
