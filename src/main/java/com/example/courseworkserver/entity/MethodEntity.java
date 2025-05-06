package com.example.courseworkserver.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "methods")
@Entity
public class MethodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "method_name", nullable = false)
    private String methodName;

    @Column(nullable = false)
    private String form;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classEntity;
}
