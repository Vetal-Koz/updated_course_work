package com.example.courseworkserver.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacultyRequest extends SubdivisionRequest {
    public String curricula;
    public String facultyLocation;
}
