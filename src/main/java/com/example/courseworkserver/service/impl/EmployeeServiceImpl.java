package com.example.courseworkserver.service.impl;

import com.example.courseworkserver.entity.Employee;
import com.example.courseworkserver.exception.EntityNotFoundException;
import com.example.courseworkserver.repository.EmployeeRepository;
import com.example.courseworkserver.service.EmployeeService;
import com.example.courseworkserver.service.PersonService;
import com.example.courseworkserver.util.ExceptionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PersonService personService;

    @Override
    public Employee create(Employee entity) {
        return employeeRepository.save(entity);
    }

    @Override
    public void update(Employee entity) {
        employeeRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.ENTITY_NOT_FOUND.getMessage()));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void ExpelFromUniversity() {
        personService.ExpelFromUniversity();
        System.out.println("Employee expel from university");
    }
}
