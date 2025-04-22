package com.example.courseworkserver.service.impl;

import com.example.courseworkserver.entity.ClassEntity;
import com.example.courseworkserver.exception.EntityNotFoundException;
import com.example.courseworkserver.repository.ClassEntityRepository;
import com.example.courseworkserver.service.ClassService;
import com.example.courseworkserver.util.ExceptionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {
    private final ClassEntityRepository classEntityRepository;

    @Override
    public ClassEntity findByClassName(String className) {
        return classEntityRepository.findClassByNameIgnoreCase(className)
                .orElseThrow(() ->
                        new EntityNotFoundException(ExceptionUtil.ENTITY_NOT_FOUND.getMessage()));
    }
}
