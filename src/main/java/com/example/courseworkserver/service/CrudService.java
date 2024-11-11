package com.example.courseworkserver.service;

import com.example.courseworkserver.entity.Uniobject;

import java.util.List;

public interface CrudService<E extends Uniobject> {
    void create(E entity);
    void update(E entity);
    void delete(Long id);
    E findById(Long id);
    List<E> findAll();
}
