package com.ignite.desafio_01.dtos.courses;

import com.ignite.desafio_01.enums.CourseActive;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCourseDto(@NotBlank(message = "name is required") String name,
                              @NotBlank(message = "category is required") String category,
                              @NotNull(message = "active is required") CourseActive active) {
}
