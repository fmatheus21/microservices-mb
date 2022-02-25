package com.microservice.email.application.service;

import com.microservice.email.application.domain.Email;
import com.microservice.email.application.domain.PageInfo;
import com.microservice.email.application.domain.enums.StatusEmailEnum;
import com.microservice.email.application.port.EmailRepositoryPort;
import com.microservice.email.application.port.EmailSendServicePort;
import com.microservice.email.application.port.EmailServicePort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EmailServicePortImpl implements EmailServicePort {

    private final EmailRepositoryPort emailRepositoryPort;
    private final EmailSendServicePort emailSendServicePort;

    public EmailServicePortImpl(final EmailRepositoryPort emailRepositoryPort, final EmailSendServicePort emailSendServicePort) {
        this.emailRepositoryPort = emailRepositoryPort;
        this.emailSendServicePort = emailSendServicePort;
    }


    @Override
    public List<Email> findAll(PageInfo pageInfo) {
        return emailRepositoryPort.findAll(pageInfo);
    }

    @Override
    public Email sendEmail(Email email) {
        email.setSendDate(LocalDateTime.now());
        try {
            emailSendServicePort.sendEmailSmtp(email);
            email.setStatus(StatusEmailEnum.SENT);
        } catch (Exception e) {
            email.setStatus(StatusEmailEnum.ERROR);
        } finally {
            return this.save(email);
        }

    }

    @Override
    public Optional<Email> findById(UUID uuid) {
        return emailRepositoryPort.findById(uuid);
    }

    @Override
    public Email save(Email email) {
        return emailRepositoryPort.save(email);
    }
}
