package com.example.courseworkserver.service;

import com.example.courseworkserver.entity.MethodEntity;

import java.util.List;
import java.util.Optional;

public interface MethodEntityService {
    List<MethodEntity> findByClassEntityName(String className);
    MethodEntity findById(Long id);
}
