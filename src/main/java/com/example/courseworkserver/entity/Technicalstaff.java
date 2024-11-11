package com.example.courseworkserver.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@ToString
@Setter
@NoArgsConstructor
@Entity
@Table(name = "techical_staff")
public class Technicalstaff extends Employee{

    private String specialization;

    @Column(name = "job_position")
    private String jobPosition;

}