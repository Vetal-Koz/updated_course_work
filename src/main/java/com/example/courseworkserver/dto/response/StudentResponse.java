package com.example.courseworkserver.dto.response;


import com.example.courseworkserver.entity.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class StudentResponse extends PersonResponse {
    private Float averageMark;
    private String universityGroup;
    private Integer practicalExperience;

    public StudentResponse(Student student) {
        BeanUtils.copyProperties(student, this);
    }
}
