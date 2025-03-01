package com.example.courseworkserver.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentRequest extends SubdivisionRequest {
    public String teachingFocus;
    public Double budget;
}
