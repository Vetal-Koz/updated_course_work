package com.example.courseworkserver.service.impl;

import com.example.courseworkserver.entity.ClassEntity;
import com.example.courseworkserver.entity.Student;
import com.example.courseworkserver.exception.EntityNotFoundException;
import com.example.courseworkserver.repository.ClassEntityRepository;
import com.example.courseworkserver.repository.StudentRepository;
import com.example.courseworkserver.service.PersonService;
import com.example.courseworkserver.service.StudentService;
import com.example.courseworkserver.util.ExceptionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ClassEntityRepository classEntityRepository;
    private final PersonService personService;

    @Override
    public Student create(Student entity) {
        ClassEntity classEntity = classEntityRepository.findClassByNameIgnoreCase("Student")
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.ENTITY_NOT_FOUND.getMessage()));
        entity.setClassEntity(classEntity);
        return studentRepository.save(entity);
    }

    @Override
    public void update(Student entity) {
        studentRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.ENTITY_NOT_FOUND.getMessage()));
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void ExpelFromUniversity(Long entityId ,String recordBook, Date expelDate) {
        personService.ExpelFromUniversity();
        System.out.println("Student expel from University");
        System.out.println("entityId = " + entityId + ", recordBook = " + recordBook + ", expelDate = " + expelDate);
    }
}
