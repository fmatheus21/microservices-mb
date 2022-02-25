package com.microservice.email.adapter.bound.outbound.persistence.springdata;

import com.microservice.email.adapter.bound.outbound.persistence.entity.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmailRepositorySpringData extends JpaRepository<EmailEntity, UUID> {
}