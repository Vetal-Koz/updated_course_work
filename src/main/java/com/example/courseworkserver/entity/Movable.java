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
@Table(name = "movable")
public class Movable extends MaterialMean {

    @Column(name = "service_life")
    private Integer serviceLife;

    private String specifications;

    @Column(name = "repair_cost")
    private Float repairCost;

}