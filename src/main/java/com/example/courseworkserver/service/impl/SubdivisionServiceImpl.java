package com.example.courseworkserver.service.impl;

import com.example.courseworkserver.entity.ClassEntity;
import com.example.courseworkserver.entity.Subdivision;
import com.example.courseworkserver.exception.EntityNotFoundException;
import com.example.courseworkserver.repository.ClassEntityRepository;
import com.example.courseworkserver.repository.SubdivisionRepository;
import com.example.courseworkserver.service.SubdivisionService;
import com.example.courseworkserver.service.UniobjectService;
import com.example.courseworkserver.util.ExceptionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubdivisionServiceImpl implements SubdivisionService {

    private final SubdivisionRepository subdivisionRepository;
    private final ClassEntityRepository classEntityRepository;
    private final UniobjectService uniobjectService;

    @Override
    public Subdivision create(Subdivision entity) {
        ClassEntity classEntity = classEntityRepository.findClassByNameIgnoreCase("Subdivision")
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.ENTITY_NOT_FOUND.getMessage()));
        entity.setClassEntity(classEntity);
        return subdivisionRepository.save(entity);
    }

    @Override
    public void update(Subdivision entity) {
        subdivisionRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        subdivisionRepository.deleteById(id);
    }

    @Override
    public Subdivision findById(Long id) {
        return subdivisionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.ENTITY_NOT_FOUND.getMessage()));
    }

    @Override
    public List<Subdivision> findAll() {
        return subdivisionRepository.findAll();
    }
}
