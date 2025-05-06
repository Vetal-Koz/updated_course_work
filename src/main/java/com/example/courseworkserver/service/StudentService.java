package com.example.courseworkserver.service;

import com.example.courseworkserver.entity.Student;

import java.time.LocalDate;
import java.util.Date;

public interface StudentService extends CrudService<Student> {
    void ExpelFromUniversity(Long entityId ,String recordBook, Date expelDate);
}
