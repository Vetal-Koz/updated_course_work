package com.example.courseworkserver.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;


@Getter
@Service
@NoArgsConstructor
@ToString
@Entity
@Table(name = "multimedia_documents")
public class MultimediaDocument extends ElectronicDocument {

    private String design;

}