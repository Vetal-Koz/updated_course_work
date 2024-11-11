package com.example.courseworkserver.repository;

import com.example.courseworkserver.entity.Immovable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImmovableRepository extends JpaRepository<Immovable, Long> {
}
