package com.example.courseworkserver.facade;

import com.example.courseworkserver.dto.request.ApiRequest;
import com.example.courseworkserver.dto.response.ApiResponse;

import java.util.List;

public interface CrudFacade <REQ extends ApiRequest, RES extends ApiResponse> {
    void create(REQ entity);
    void update(REQ entity, Long id);
    void delete(Long id);
    RES findById(Long id);
    List<RES> findAll();
}
