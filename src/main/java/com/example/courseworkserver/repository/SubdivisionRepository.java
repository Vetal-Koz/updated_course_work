package com.example.courseworkserver.repository;

import com.example.courseworkserver.entity.Subdivision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SubdivisionRepository extends JpaRepository<Subdivision, Long> {
}
