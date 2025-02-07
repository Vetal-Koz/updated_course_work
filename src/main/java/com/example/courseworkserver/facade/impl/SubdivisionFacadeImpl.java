package com.example.courseworkserver.facade.impl;


import com.example.courseworkserver.dto.request.SubdivisionRequest;
import com.example.courseworkserver.dto.response.SubdivisionResponse;
import com.example.courseworkserver.entity.Subdivision;
import com.example.courseworkserver.facade.SubdivisionFacade;
import com.example.courseworkserver.service.SubdivisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubdivisionFacadeImpl implements SubdivisionFacade {
    private final SubdivisionService subdivisionService;
    @Override
    public SubdivisionResponse create(SubdivisionRequest entity) {
        Subdivision subdivision = new Subdivision();
        BeanUtils.copyProperties(entity, subdivision);
        Subdivision response = subdivisionService.create(subdivision);
        return new SubdivisionResponse(response);
    }

    @Override
    public void update(SubdivisionRequest entity, Long id) {
        Subdivision subdivision = subdivisionService.findById(id);
        BeanUtils.copyProperties(entity, subdivision);
        subdivisionService.update(subdivision);
    }

    @Override
    public void delete(Long id) {
        subdivisionService.delete(id);
    }

    @Override
    public SubdivisionResponse findById(Long id) {
        return new SubdivisionResponse(subdivisionService.findById(id));
    }

    @Override
    public List<SubdivisionResponse> findAll() {
        return subdivisionService.findAll().stream().map(SubdivisionResponse::new).toList();
    }
}
