package com.example.courseworkserver.service;

import com.example.courseworkserver.entity.Employee;

public interface EmployeeService extends CrudService<Employee> {
    void ExpelFromUniversity();
}
