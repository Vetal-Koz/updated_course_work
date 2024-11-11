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
@Table(name = "material_means")
public class MaterialMean extends Uniobject{

    private Integer amount;

    @Column(name = "physical_condition")
    private String physicalCondition;

    @Column(name = "mean_cost")
    private Float meanCost;

}