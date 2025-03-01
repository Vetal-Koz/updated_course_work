package com.example.courseworkserver.facade.impl;

import com.example.courseworkserver.dto.request.PersonRequest;
import com.example.courseworkserver.dto.response.PersonResponse;
import com.example.courseworkserver.entity.Person;
import com.example.courseworkserver.facade.PersonFacade;
import com.example.courseworkserver.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonFacadeImpl implements PersonFacade {
    private final PersonService personService;
    @Override
    public PersonResponse create(PersonRequest entity) {
        Person person = new Person();
        BeanUtils.copyProperties(entity, person);
        Person response = personService.create(person);
        return new PersonResponse(response);
    }

    @Override
    public void update(PersonRequest entity, Long id) {
        Person person = personService.findById(id);
        BeanUtils.copyProperties(entity, person);
        personService.update(person);
    }

    @Override
    public void delete(Long id) {
        personService.delete(id);
    }

    @Override
    public PersonResponse findById(Long id) {
        return new PersonResponse(personService.findById(id));
    }

    @Override
    public List<PersonResponse> findAll() {
        return personService.findAll()
                .stream()
                .map(PersonResponse::new)
                .toList();
    }
}
