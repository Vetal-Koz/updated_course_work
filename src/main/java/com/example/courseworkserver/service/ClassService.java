package com.example.courseworkserver.service;

import com.example.courseworkserver.entity.ClassEntity;

public interface ClassService {
    ClassEntity findByClassName(String className);
}
