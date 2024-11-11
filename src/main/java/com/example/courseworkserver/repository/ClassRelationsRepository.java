package com.example.courseworkserver.repository;

import com.example.courseworkserver.entity.ClassRelations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRelationsRepository extends JpaRepository<ClassRelations, Long> {
}
