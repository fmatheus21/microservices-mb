package com.microservice.email.application.port;

import com.microservice.email.application.domain.Email;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;


public interface EmailServicePort {

    Page<Email> findAll(Pageable pageable);

    Email sendEmail(Email email);

    Optional<Email> findById(UUID uuid);

    Email save(Email email);


}
