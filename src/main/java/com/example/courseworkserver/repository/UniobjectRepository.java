package com.example.courseworkserver.repository;

import com.example.courseworkserver.entity.Uniobject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniobjectRepository extends JpaRepository<Uniobject, Long> {

    @Query("SELECT uni FROM Uniobject uni WHERE uni.major IS NULL OR uni.major = 0")
    List<Uniobject> findAllByMajorIsNull();

    List<Uniobject> findAllByMajorIs(Long major);

    @Query(value = "select c.name from class_relations inner join public.classes c on c.id = class_relations.child_class_id where parent_class_id = :id", nativeQuery = true)
    List<String> findAllRelatedClassesById(@Param("id") Long id);
}
