package com.example.courseworkserver.repository;

import com.example.courseworkserver.entity.MultimediaDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultimediaDocumentRepository extends JpaRepository<MultimediaDocument, Long> {
}
