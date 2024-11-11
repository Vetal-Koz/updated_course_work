package com.example.courseworkserver.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "uniobjects")
public class Uniobject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "object_name")
    private String name;

    private Long major;

    @OneToOne
    @JoinColumn(name = "class_id",referencedColumnName = "id")
    private ClassEntity classEntity;

}