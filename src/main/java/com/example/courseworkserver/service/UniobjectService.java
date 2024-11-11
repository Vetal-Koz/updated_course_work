package com.example.courseworkserver.service;

import com.example.courseworkserver.entity.Uniobject;

import java.util.List;

public interface UniobjectService extends CrudService<Uniobject> {

    List<Uniobject> findAllWithMajorNull();

    List<Uniobject> findAllByMajorIs(Long major);

    List<String> findAllRelatedClassesNameById(Long id);
}
