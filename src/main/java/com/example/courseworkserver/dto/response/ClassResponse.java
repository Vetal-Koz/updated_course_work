package com.example.courseworkserver.dto.response;

import com.example.courseworkserver.entity.ClassEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClassResponse extends ApiResponse {
    private String name;
    private String form;

    public ClassResponse(ClassEntity classEntity) {
        setId(classEntity.getId());
        setName(classEntity.getName());
        setForm(classEntity.getForm());
    }
}
