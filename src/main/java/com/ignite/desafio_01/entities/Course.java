package com.ignite.desafio_01.entities;

import com.ignite.desafio_01.enums.CourseActive;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Table(name="courses")
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String category;

    @Enumerated(EnumType.STRING)
    private CourseActive active;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public CourseActive getActive() {
        return active;
    }

    public void setActive(CourseActive active) {
        this.active = active;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Course() {
    }

    public Course(CourseActive active, String category, LocalDateTime createdAt, UUID id, String name, LocalDateTime updatedAt) {
        this.active = active;
        this.category = category;
        this.createdAt = createdAt;
        this.id = id;
        this.name = name;
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) && Objects.equals(name, course.name) && Objects.equals(category, course.category) && Objects.equals(active, course.active) && Objects.equals(createdAt, course.createdAt) && Objects.equals(updatedAt, course.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, active, createdAt, updatedAt);
    }
}
