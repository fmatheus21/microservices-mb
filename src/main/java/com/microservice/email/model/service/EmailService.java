package com.microservice.email.model.service;


import com.microservice.email.model.entity.Email;
import com.microservice.email.model.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class EmailService extends SortService implements GenericService<Email, UUID> {

    @Autowired
    private EmailRepository repository;

    @Override
    public List<Email> findAllSortAsc(String attribute) {
        return this.repository.findAll(sortAsc(attribute));
    }

    @Override
    public List<Email> findAllSortDesc(String attribute) {
        return this.repository.findAll(sortDesc(attribute));
    }

    @Override
    public Optional<Email> findById(UUID uuid) {
        return this.repository.findById(uuid);
    }

    @Override
    public <S extends Email> S save(S s) {
        return this.repository.save(s);
    }

    @Override
    public void deleteById(UUID uuid) {
        this.repository.deleteById(uuid);
    }


}
