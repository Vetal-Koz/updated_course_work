package com.example.courseworkserver.repository;

import com.example.courseworkserver.entity.Technicalstaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalstaffRepository extends JpaRepository<Technicalstaff, Long> {
}
