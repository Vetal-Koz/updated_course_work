package com.example.courseworkserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@Table(name = "people")
public class Person extends Uniobject {

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    private String sex;

    private String nationality;

}