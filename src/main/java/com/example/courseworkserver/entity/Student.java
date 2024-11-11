package com.example.courseworkserver.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student extends Person {

    @Column(name = "avarage_mark")
    private Float averageMark;

    @Column(name = "university_group")
    private String universityGroup;

    @Column(name = "pracical_experience")
    private Integer practicalExperience;
}