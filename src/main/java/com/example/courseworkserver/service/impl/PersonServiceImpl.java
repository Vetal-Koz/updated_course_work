package com.example.courseworkserver.service.impl;

import com.example.courseworkserver.entity.ClassEntity;
import com.example.courseworkserver.entity.Person;
import com.example.courseworkserver.exception.EntityNotFoundException;
import com.example.courseworkserver.repository.ClassEntityRepository;
import com.example.courseworkserver.repository.PersonRepository;
import com.example.courseworkserver.service.PersonService;
import com.example.courseworkserver.util.ExceptionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final ClassEntityRepository classEntityRepository;

    @Override
    public Person create(Person entity) {
        ClassEntity classEntity = classEntityRepository.findClassByNameIgnoreCase("Person")
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.ENTITY_NOT_FOUND.getMessage()));
        entity.setClassEntity(classEntity);
        return personRepository.save(entity);
    }

    @Override
    public void update(Person entity) {
        personRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.ENTITY_NOT_FOUND.getMessage()));
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
