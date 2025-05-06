package com.example.courseworkserver.service;

import com.example.courseworkserver.entity.Teacher;

public interface TeacherService extends CrudService<Teacher> {
    void ExpelFromUniversity();
}
