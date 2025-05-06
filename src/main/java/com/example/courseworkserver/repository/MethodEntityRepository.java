package com.example.courseworkserver.repository;

import com.example.courseworkserver.entity.MethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MethodEntityRepository extends JpaRepository<MethodEntity, Long> {
    List<MethodEntity> findByClassEntity_Id(Long classId);
}
