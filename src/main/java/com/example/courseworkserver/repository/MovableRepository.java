package com.example.courseworkserver.repository;

import com.example.courseworkserver.entity.Movable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovableRepository extends JpaRepository<Movable, Long> {
}
