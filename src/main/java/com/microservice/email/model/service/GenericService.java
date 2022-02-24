package com.microservice.email.model.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID> {

    List<T> findAllSortAsc(String attribute);

    List<T> findAllSortDesc(String attribute);

    Optional<T> findById(ID id);

    <S extends T> S save(S s);

    void deleteById(ID id);
}
