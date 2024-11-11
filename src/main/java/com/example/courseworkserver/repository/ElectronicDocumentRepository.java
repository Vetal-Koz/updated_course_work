package com.example.courseworkserver.repository;

import com.example.courseworkserver.entity.ElectronicDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectronicDocumentRepository extends JpaRepository<ElectronicDocument, Long> {
}