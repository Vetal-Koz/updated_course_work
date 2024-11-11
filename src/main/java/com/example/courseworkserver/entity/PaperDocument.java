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
@Table(name = "paper_documents")
public class PaperDocument extends Document {

    @Column(name = "numberOfPages")
    private Integer numberOfPages;

    private Boolean archiving;


}