package com.example.courseworkserver.dto.response;

import com.example.courseworkserver.entity.ClassEntity;
import com.example.courseworkserver.entity.MethodEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MethodEntityResponse {

    private Long id;

    private String methodName;

    private String form;

    private Long classId;

    public MethodEntityResponse(MethodEntity methodEntity) {
        this.id = methodEntity.getId();
        this.methodName = methodEntity.getMethodName();
        this.form = methodEntity.getForm();
        this.classId = methodEntity.getClassEntity().getId();
    }
}
