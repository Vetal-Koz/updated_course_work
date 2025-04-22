package com.example.courseworkserver.dto.response;


import com.example.courseworkserver.entity.Faculty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FacultyResponse extends SubdivisionResponse {
    private String curricula;

    private String facultyLocation;

    public FacultyResponse(Faculty faculty) {
        setId(faculty.getId());
        setName(faculty.getName());
        setMajor(faculty.getMajor());
        setClassEntityName(faculty.getClassEntity().getName());
        setChef(faculty.getChef().getName());
        setChefId(faculty.getChef().getId());
        this.curricula = faculty.getCurricula();
        this.facultyLocation = faculty.getFacultyLocation();
    }
}
