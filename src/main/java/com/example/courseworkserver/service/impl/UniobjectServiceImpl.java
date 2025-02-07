package com.example.courseworkserver.service.impl;

import com.example.courseworkserver.entity.ClassEntity;
import com.example.courseworkserver.entity.Uniobject;
import com.example.courseworkserver.exception.EntityNotFoundException;
import com.example.courseworkserver.repository.ClassEntityRepository;
import com.example.courseworkserver.repository.UniobjectRepository;
import com.example.courseworkserver.service.UniobjectService;
import com.example.courseworkserver.util.ExceptionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UniobjectServiceImpl implements UniobjectService {

    private final UniobjectRepository uniobjectRepository;
    private final ClassEntityRepository classEntityRepository;

    @Override
    public Uniobject create(Uniobject entity) {
        ClassEntity classEntity = classEntityRepository.findClassByName("Uniobject")
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.ENTITY_NOT_FOUND.getMessage()));
        entity.setClassEntity(classEntity);
        return uniobjectRepository.save(entity);
    }

    @Override
    public void update(Uniobject entity) {
        if (entity.getMajor() == 0) {
            entity.setMajor(null);
        }
        uniobjectRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        uniobjectRepository.deleteById(id);
    }

    @Override
    public Uniobject findById(Long id) {
        return uniobjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.ENTITY_NOT_FOUND.getMessage()));
    }

    @Override
    public List<Uniobject> findAll() {
        return uniobjectRepository.findAll();
    }

    @Override
    public List<Uniobject> findAllWithMajorNull() {
        return uniobjectRepository.findAllByMajorIsNull();
    }

    @Override
    public List<Uniobject> findAllByMajorIs(Long major) {
        return uniobjectRepository.findAllByMajorIs(major);
    }

    @Override
    public List<String> findAllRelatedClassesNameById(Long id) {
        return uniobjectRepository.findAllRelatedClassesById(id);
    }
}
