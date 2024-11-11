package com.example.courseworkserver.dto.response;


import com.example.courseworkserver.entity.Uniobject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UniobjectResponse extends ApiResponse{

    private String name;

    private Long major;

    private Long classEntityId;

    public UniobjectResponse(Uniobject uniobject) {
        setId(uniobject.getId());
        setName(uniobject.getName());
        setMajor(uniobject.getMajor());
        setClassEntityId(uniobject.getClassEntity().getId());
    }

}
