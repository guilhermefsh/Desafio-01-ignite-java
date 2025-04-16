package com.ignite.desafio_01.controllers;

import com.ignite.desafio_01.dtos.courses.CreateCourseDto;
import com.ignite.desafio_01.entities.Course;
import com.ignite.desafio_01.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CouseController {

    @Autowired
    CourseService courseService;

    @PostMapping
    ResponseEntity<Course> createCourse(@RequestBody @Valid CreateCourseDto userDto){
        Course createdCourse = courseService.createCourse(userDto);
        return ResponseEntity.ok(createdCourse);
    }
}
