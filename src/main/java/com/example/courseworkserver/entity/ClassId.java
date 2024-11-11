package com.example.courseworkserver.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ClassId implements Serializable {

    private Long parentClassId;

    private Long childClassId;
}
