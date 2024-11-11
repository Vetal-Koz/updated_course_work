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
@Table(name = "immovable")
public class Immovable extends MaterialMean {

    private Float area;

    private String address;

    @Column(name = "functional_purpose")
    private String functionalPurpose;

}