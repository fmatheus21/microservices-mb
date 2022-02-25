package com.microservice.email.application.port;

import com.microservice.email.application.domain.Email;
import com.microservice.email.application.domain.PageInfo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface EmailServicePort {

    List<Email> findAll(PageInfo pageInfo);

    Email sendEmail(Email email);

    Optional<Email> findById(UUID uuid);

    Email save(Email email);


}
