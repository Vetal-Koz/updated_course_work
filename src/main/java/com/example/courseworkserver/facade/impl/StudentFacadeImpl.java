package com.example.courseworkserver.facade.impl;

import com.example.courseworkserver.dto.request.StudentRequest;
import com.example.courseworkserver.dto.response.StudentResponse;
import com.example.courseworkserver.entity.Student;
import com.example.courseworkserver.facade.StudentFacade;
import com.example.courseworkserver.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentFacadeImpl implements StudentFacade {

    private final StudentService studentService;
    @Override
    public StudentResponse create(StudentRequest entity) {
        Student student = new Student();
        BeanUtils.copyProperties(entity, student);
        Student response = studentService.create(student);
        return new StudentResponse(response);
    }

    @Override
    public void update(StudentRequest entity, Long id) {
        Student student = studentService.findById(id);
        BeanUtils.copyProperties(entity, student);
        studentService.update(student);
    }

    @Override
    public void delete(Long id) {
        studentService.delete(id);
    }

    @Override
    public StudentResponse findById(Long id) {
        return new StudentResponse(studentService.findById(id));
    }

    @Override
    public List<StudentResponse> findAll() {
        return studentService.findAll().stream().map(StudentResponse::new).toList();
    }
}
