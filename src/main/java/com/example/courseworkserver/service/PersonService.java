package com.example.courseworkserver.service;

import com.example.courseworkserver.entity.Person;

public interface PersonService extends CrudService<Person> {
    void ExpelFromUniversity();
}
