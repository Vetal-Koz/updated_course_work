package com.example.courseworkserver.facade.impl;

import com.example.courseworkserver.dto.request.DepartmentRequest;
import com.example.courseworkserver.dto.response.DepartmentResponse;
import com.example.courseworkserver.entity.Department;
import com.example.courseworkserver.entity.Person;
import com.example.courseworkserver.facade.DepartmentFacade;
import com.example.courseworkserver.service.DepartmentService;
import com.example.courseworkserver.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentFacadeImpl implements DepartmentFacade {
    private final DepartmentService departmentService;
    private final PersonService personService;

    @Override
    public DepartmentResponse create(DepartmentRequest entity) {
        Department department = new Department();
        BeanUtils.copyProperties(entity, department);
        department.setChef(getChefWithChecking(entity.getChefId()));
        Department response = departmentService.create(department);
        return new DepartmentResponse(response);
    }

    @Override
    public void update(DepartmentRequest entity, Long id) {
        Department department = departmentService.findById(id);
        BeanUtils.copyProperties(entity, department);
        department.setChef(getChefWithChecking(entity.getChefId()));
        departmentService.update(department);
    }

    @Override
    public void delete(Long id) {
        departmentService.delete(id);
    }

    @Override
    public DepartmentResponse findById(Long id) {
        return new DepartmentResponse(departmentService.findById(id));
    }

    @Override
    public List<DepartmentResponse> findAll() {
        return departmentService.findAll().stream().map(DepartmentResponse::new).toList();
    }

    private Person getChefWithChecking(Long chefId) {
        if (chefId != null) {
            return personService.findById(chefId);
        }
        return null;
    }
}
