package com.ignite.desafio_01.controllers;

import com.ignite.desafio_01.dtos.courses.CreateCourseDto;
import com.ignite.desafio_01.dtos.courses.EditCourseDto;
import com.ignite.desafio_01.entities.Course;
import com.ignite.desafio_01.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cursos")
public class CouseController {

    @Autowired
    CourseService courseService;

    @PostMapping
    ResponseEntity<Void> createCourse(@RequestBody @Valid CreateCourseDto userDto){
        Course createdCourse = courseService.createCourse(userDto);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    ResponseEntity<List<Course>> getAllCourses(){
        List<Course> allCourses = this.courseService.getAllCourses();
        return ResponseEntity.ok(allCourses);
    }

    @PutMapping("/{id}")
    ResponseEntity<Course> editCourse(@RequestBody EditCourseDto courseDto, @PathVariable UUID id){
        Course editCourse = courseService.editCourse(id, courseDto);

        return ResponseEntity.ok(editCourse);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Course> deleteCourse(@PathVariable UUID id){
        courseService.deleteCourse(id);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/active")
    ResponseEntity<Course> toggleActive(@PathVariable UUID id){
        Course updatedCourse = courseService.toggleActive(id);
        return ResponseEntity.ok(updatedCourse);
    }
}
