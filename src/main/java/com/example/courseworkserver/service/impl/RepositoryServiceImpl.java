package com.example.courseworkserver.service.impl;

import com.example.courseworkserver.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

@Service
public class RepositoryServiceImpl implements RepositoryService {

    private final Repositories repositories;

    @Autowired
    public RepositoryServiceImpl(ListableBeanFactory beanFactory) {
        this.repositories = new Repositories(beanFactory);
    }


    @Override
    public JpaRepository getRepository(Class<?> entityClass) {
        Optional<Object> repo = repositories.getRepositoryFor(entityClass);
        if (repo.isPresent()) {
            if(repo.get() instanceof JpaRepository) {
                return (JpaRepository) repo.get();
            }
        }
        throw new RuntimeException("Such repository doesn't exist");
    }
}
