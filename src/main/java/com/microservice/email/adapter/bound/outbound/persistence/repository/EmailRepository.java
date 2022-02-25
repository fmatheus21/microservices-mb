package com.microservice.email.adapter.bound.outbound.persistence.repository;

import com.microservice.email.adapter.bound.outbound.persistence.entity.EmailEntity;
import com.microservice.email.adapter.bound.outbound.persistence.springdata.EmailRepositorySpringData;
import com.microservice.email.application.domain.Email;
import com.microservice.email.application.domain.PageInfo;
import com.microservice.email.application.port.EmailRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Primary
public class EmailRepository implements EmailRepositoryPort {

    private final EmailRepositorySpringData emailRepository;

    public EmailRepository(final EmailRepositorySpringData emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Email save(Email email) {
        var mapper = modelMapper.map(email, EmailEntity.class);
        var emailEntity = emailRepository.save(mapper);
        return this.converter(emailEntity);
    }

    @Override
    public List<Email> findAll(PageInfo pageInfo) {
        var pageable = PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize());
        return emailRepository.findAll(pageable).stream().map(this::converter)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Email> findById(UUID uuid) {
        Optional<EmailEntity> emailEntity = emailRepository.findById(uuid);
        return emailEntity.map(entity -> modelMapper.map(entity, Email.class));
    }

    private Email converter(EmailEntity emailEntity) {
        return modelMapper.map(emailEntity, Email.class);
    }
}
