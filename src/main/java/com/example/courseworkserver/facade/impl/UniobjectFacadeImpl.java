package com.example.courseworkserver.facade.impl;

import com.example.courseworkserver.dto.request.UniobjectRequest;
import com.example.courseworkserver.dto.response.UniobjectResponse;
import com.example.courseworkserver.entity.Uniobject;
import com.example.courseworkserver.facade.UniobjectFacade;
import com.example.courseworkserver.service.UniobjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniobjectFacadeImpl implements UniobjectFacade {

    private final UniobjectService uniobjectService;

    @Override
    public void create(UniobjectRequest entity) {
        Uniobject uniobject = new Uniobject();
        uniobject.setName(entity.getName());
        uniobject.setMajor(entity.getMajor());
        uniobjectService.create(uniobject);
    }

    @Override
    public void update(UniobjectRequest entity, Long id) {
        Uniobject uniobject = uniobjectService.findById(id);
        uniobject.setName(entity.getName());
        uniobject.setMajor(entity.getMajor());
        uniobjectService.update(uniobject);
    }

    @Override
    public void delete(Long id) {
        uniobjectService.delete(id);
    }

    @Override
    public UniobjectResponse findById(Long id) {
        return new UniobjectResponse(uniobjectService.findById(id));
    }

    @Override
    public List<UniobjectResponse> findAll() {
        return uniobjectService.findAll().stream().map(UniobjectResponse::new).toList();
    }

    @Override
    public List<UniobjectResponse> findAllWithMajorNull() {
        return uniobjectService.findAllWithMajorNull().stream().map(UniobjectResponse::new).toList();
    }

    @Override
    public List<UniobjectResponse> findAllByMajorIs(Long major) {
        return uniobjectService.findAllByMajorIs(major).stream().map(UniobjectResponse::new).toList();
    }

    @Override
    public List<String> findAllRelatedClassesNameById(Long id) {
        return uniobjectService.findAllRelatedClassesNameById(id);
    }

    @Override
    public void updateMajor(Long id, Long parentId) {
        Uniobject uniobject = uniobjectService.findById(id);
        uniobject.setMajor(parentId);
        uniobjectService.update(uniobject);
    }
}
