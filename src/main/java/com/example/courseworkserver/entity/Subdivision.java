package com.example.courseworkserver.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "chef_id", nullable = true)
    private Person chef;

}