package com.ignite.desafio_01.services;

import com.ignite.desafio_01.dtos.courses.CreateCourseDto;
import com.ignite.desafio_01.entities.Course;
import com.ignite.desafio_01.exceptions.CourseAlreadyExistsException;
import com.ignite.desafio_01.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Course createCourse(CreateCourseDto data){
        this.courseRepository.findByName(data.name())
                .ifPresent(course -> {
                    throw new CourseAlreadyExistsException();
                });

        var newCourse = new Course();
        newCourse.setName(data.name());
        newCourse.setCategory(data.category());
        newCourse.setActive(data.active());

        return courseRepository.save(newCourse);
    }
}
