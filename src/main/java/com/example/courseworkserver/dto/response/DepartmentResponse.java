package com.example.courseworkserver.dto.response;

import com.example.courseworkserver.entity.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DepartmentResponse extends SubdivisionResponse {
    private String teachingFocus;

    private Float budget;

    public DepartmentResponse(Department department) {
        setId(department.getId());
        setName(department.getName());
        setMajor(department.getMajor());
        setClassEntityName(department.getClassEntity().getName());
        setChef(department.getChef());
        this.teachingFocus = department.getTeachingFocus();
        this.budget = department.getBudget();
    }

}
