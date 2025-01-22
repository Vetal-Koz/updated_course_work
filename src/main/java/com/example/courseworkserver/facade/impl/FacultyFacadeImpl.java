package com.example.courseworkserver.facade.impl;

import com.example.courseworkserver.dto.request.FacultyRequest;
import com.example.courseworkserver.dto.response.FacultyResponse;
import com.example.courseworkserver.entity.Faculty;
import com.example.courseworkserver.facade.FacultyFacade;
import com.example.courseworkserver.service.FacultyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FacultyFacadeImpl implements FacultyFacade {
    private final FacultyService facultyService;

    @Override
    public void create(FacultyRequest entity) {
        Faculty faculty = new Faculty();
        BeanUtils.copyProperties(entity, faculty);
        facultyService.create(faculty);
    }

    @Override
    public void update(FacultyRequest entity, Long id) {
        Faculty faculty = facultyService.findById(id);
        BeanUtils.copyProperties(entity, faculty);
        facultyService.update(faculty);
    }

    @Override
    public void delete(Long id) {
        facultyService.delete(id);
    }

    @Override
    public FacultyResponse findById(Long id) {
        return new FacultyResponse(facultyService.findById(id));
    }

    @Override
    public List<FacultyResponse> findAll() {
        return facultyService.findAll().stream().map(FacultyResponse::new).toList();
    }
}
