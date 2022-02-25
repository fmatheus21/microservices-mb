package com.microservice.email.application.port;

import com.microservice.email.application.domain.Email;
import com.microservice.email.application.domain.PageInfo;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmailRepositoryPort {

    Email save(Email email);

    List<Email> findAll(PageInfo pageInfo);

    Optional<Email> findById(UUID uuid);


}
