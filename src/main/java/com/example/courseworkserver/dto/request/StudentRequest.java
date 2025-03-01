package com.example.courseworkserver.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest extends PersonRequest {
    private Float averageMark;
    private String universityGroup;
    private Integer practicalExperience;
}
