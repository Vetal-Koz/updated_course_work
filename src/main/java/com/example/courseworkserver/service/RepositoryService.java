package com.example.courseworkserver.service;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryService {

    JpaRepository getRepository(Class<?> entityClass);
}
