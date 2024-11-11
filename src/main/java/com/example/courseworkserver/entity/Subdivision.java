package com.example.courseworkserver.entity;


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
@Table(name = "subdivisions")
public class Subdivision extends Uniobject {

    private String chef;

}