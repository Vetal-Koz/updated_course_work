package com.example.courseworkserver.repository;

import com.example.courseworkserver.entity.MaterialMean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialMeanRepository extends JpaRepository<MaterialMean, Long> {
}
