package com.microservice.email.application.port;

import com.microservice.email.application.domain.Email;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface EmailRepositoryPort {

    Email save(Email email);

    Collection<Email> findAll(Pageable pageable);

    Optional<Email> findById(UUID uuid);


}
