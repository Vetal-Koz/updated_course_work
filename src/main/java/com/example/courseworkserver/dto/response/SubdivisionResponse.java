package com.example.courseworkserver.dto.response;

import com.example.courseworkserver.entity.Subdivision;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubdivisionResponse extends UniobjectResponse {
    private String chef;

    public SubdivisionResponse(Subdivision subdivision) {
        setId(subdivision.getId());
        setName(subdivision.getName());
        setMajor(subdivision.getMajor());
        setClassEntityName(subdivision.getClassEntity().getName());
        this.chef = subdivision.getChef().getName();
    }
}
