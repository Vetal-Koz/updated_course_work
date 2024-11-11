package com.example.courseworkserver.repository;

import com.example.courseworkserver.entity.TextDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextDocumentRepository extends JpaRepository<TextDocument, Long> {
}
