package com.example.courseworkserver.facade;

import com.example.courseworkserver.dto.request.UniobjectRequest;
import com.example.courseworkserver.dto.response.UniobjectResponse;
import com.example.courseworkserver.entity.Uniobject;

import java.util.List;

public interface UniobjectFacade extends CrudFacade<UniobjectRequest, UniobjectResponse> {
    List<UniobjectResponse> findAllWithMajorNull();

    List<UniobjectResponse> findAllByMajorIs(Long major);

    List<String> findAllRelatedClassesNameById(Long id);
}

