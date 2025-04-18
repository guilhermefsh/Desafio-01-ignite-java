package com.ignite.desafio_01.repository;

import com.ignite.desafio_01.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository <Course, UUID> {
    Optional<Course> findByName(String name);
    Optional<Course> findByNameIgnoreCase(String name);
}
