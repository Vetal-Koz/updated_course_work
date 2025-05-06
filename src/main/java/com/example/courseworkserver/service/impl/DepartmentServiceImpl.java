package com.example.courseworkserver.service.impl;

import com.example.courseworkserver.entity.ClassEntity;
import com.example.courseworkserver.entity.Department;
import com.example.courseworkserver.exception.EntityNotFoundException;
import com.example.courseworkserver.repository.ClassEntityRepository;
import com.example.courseworkserver.repository.DepartmentRepository;
import com.example.courseworkserver.service.DepartmentService;
import com.example.courseworkserver.service.SubdivisionService;
import com.example.courseworkserver.util.ExceptionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ClassEntityRepository classEntityRepository;
    private final SubdivisionService subdivisionService;


    @Override
    public Department create(Department entity) {
        ClassEntity classEntity = classEntityRepository.findClassByNameIgnoreCase("Department")
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.ENTITY_NOT_FOUND.getMessage()));
        entity.setClassEntity(classEntity);
        return departmentRepository.save(entity);
    }

    @Override
    public void update(Department entity) {
        departmentRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.ENTITY_NOT_FOUND.getMessage()));
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
}
