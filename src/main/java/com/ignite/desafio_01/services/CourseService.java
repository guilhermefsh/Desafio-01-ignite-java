package com.ignite.desafio_01.services;

import com.ignite.desafio_01.dtos.courses.CreateCourseDto;
import com.ignite.desafio_01.dtos.courses.EditCourseDto;
import com.ignite.desafio_01.entities.Course;
import com.ignite.desafio_01.enums.CourseActive;
import com.ignite.desafio_01.exceptions.CourseAlreadyExistsException;
import com.ignite.desafio_01.exceptions.NotFoundException;
import com.ignite.desafio_01.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Course createCourse(CreateCourseDto data){
        this.courseRepository.findByNameIgnoreCase(data.name())
                .ifPresent(course -> {
                    throw new CourseAlreadyExistsException();
                });

        var newCourse = new Course();
        newCourse.setName(data.name());
        newCourse.setCategory(data.category());
        newCourse.setActive(data.active());

        return courseRepository.save(newCourse);
    }

    public List<Course> getAllCourses(){
        return this.courseRepository.findAll();
    }

    public Course editCourse(UUID id, EditCourseDto data){
       Course course = this.courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Curso não encontrado"));

       data.name().ifPresent(course::setName);
       data.category().ifPresent(course::setCategory);

       return courseRepository.save(course);
    }

    public void deleteCourse(UUID id){
        Course course = this.courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Curso não encontrado"));

        courseRepository.delete(course);
    }

    public Course toggleActive(UUID id) {
        Course course = this.courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Curso não encontrado"));

        course.setActive(
                course.getActive() == CourseActive.ACTIVE
                        ? CourseActive.INACTIVE
                        : CourseActive.ACTIVE
        );

        return courseRepository.save(course);
    }
}
