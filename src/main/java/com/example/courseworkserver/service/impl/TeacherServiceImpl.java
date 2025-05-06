package com.example.courseworkserver.service.impl;

import com.example.courseworkserver.entity.Teacher;
import com.example.courseworkserver.exception.EntityNotFoundException;
import com.example.courseworkserver.repository.TeacherRepository;
import com.example.courseworkserver.service.EmployeeService;
import com.example.courseworkserver.service.TeacherService;
import com.example.courseworkserver.util.ExceptionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final EmployeeService employeeService;
    @Override
    public Teacher create(Teacher entity) {
        return teacherRepository.save(entity);
    }

    @Override
    public void update(Teacher entity) {
        teacherRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher findById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.ENTITY_NOT_FOUND.getMessage()));
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public void ExpelFromUniversity() {
        employeeService.ExpelFromUniversity();
        System.out.println("Teacher expel from university");
    }
}
