package com.example.courseworkserver.dto.response;


import com.example.courseworkserver.entity.Uniobject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UniobjectResponse extends ApiResponse{

    private String name;

    private Long major;

    private String classEntityName;
    private List<?> items = new ArrayList<>();
    private Boolean isDirectory = false;
    private Boolean expanded = false;

    public UniobjectResponse(Uniobject uniobject) {
        setId(uniobject.getId());
        setName(uniobject.getName());
        setMajor(uniobject.getMajor());
        setClassEntityName(uniobject.getClassEntity().getName());
    }

}
