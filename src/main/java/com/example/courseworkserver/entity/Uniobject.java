package com.example.courseworkserver.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "uniobjects")
public class Uniobject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "object_name")
    private String name;

    private Long major;

    @ManyToOne
    @JoinColumn(name = "class_id",referencedColumnName = "id")
    private ClassEntity classEntity;


}