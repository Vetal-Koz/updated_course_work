package com.example.courseworkserver.repository;

import com.example.courseworkserver.entity.PaperDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperDocumentRepository extends JpaRepository<PaperDocument, Long> {
}
