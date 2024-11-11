package com.example.courseworkserver.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "class_relations")
@IdClass(ClassId.class)
public class ClassRelations {

    @Id
    @Column(name = "parent_class_id")
    private Long parentClassId;

    @Id
    @Column(name = "child_class_id")
    private Long childClassId;
}
