package com.example.courseworkserver.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "electronic_documents")
public class ElectronicDocument extends Document{
    private String format;

    @Column(name = "document_size")
    private Float docSize;

    @Column(name = "document_security")
    private Boolean docSecurity;

}