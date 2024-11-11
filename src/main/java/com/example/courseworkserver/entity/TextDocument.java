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
@Table(name = "text_documents")
public class TextDocument extends ElectronicDocument {

    @Column(name = "font_family")
    private String fontFamily;

    @Column(name = "text_structure")
    private String textStructure;


}