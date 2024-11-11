package com.example.courseworkserver.entity;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "teachers")
public class Teacher extends Employee{

    private String subject;

    @Column(name = "academic_titles")
    private String academicTitles;

    private Float rating;

}