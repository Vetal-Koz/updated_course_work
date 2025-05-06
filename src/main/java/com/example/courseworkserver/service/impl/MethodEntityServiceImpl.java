package com.example.courseworkserver.service.impl;

import com.example.courseworkserver.entity.ClassEntity;
import com.example.courseworkserver.entity.MethodEntity;
import com.example.courseworkserver.exception.EntityNotFoundException;
import com.example.courseworkserver.repository.ClassEntityRepository;
import com.example.courseworkserver.repository.MethodEntityRepository;
import com.example.courseworkserver.service.MethodEntityService;
import com.example.courseworkserver.util.ExceptionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MethodEntityServiceImpl implements MethodEntityService {
    private final MethodEntityRepository methodEntityRepository;
    private final ClassEntityRepository classEntityRepository;

    @Override
    public List<MethodEntity> findByClassEntityName(String className) {
        ClassEntity classEntity = classEntityRepository.findClassByNameIgnoreCase(className)
                .orElseThrow(() ->
                        new EntityNotFoundException(ExceptionUtil.ENTITY_NOT_FOUND.getMessage()));
        return methodEntityRepository.findByClassEntity_Id(classEntity.getId());
    }

    @Override
    public MethodEntity findById(Long id) {
        return methodEntityRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.ENTITY_NOT_FOUND.getMessage()));
    }
}
