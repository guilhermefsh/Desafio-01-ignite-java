package com.ignite.desafio_01.dtos.courses;

import com.ignite.desafio_01.enums.CourseActive;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCourseDto(@Schema(example = "Fundamentos Next.js") @NotBlank(message = "name is required") String name,
                              @Schema(example = "Formação")@NotBlank(message = "category is required") String category,
                              @Schema(example = "ACTIVE")@NotNull(message = "active is required") CourseActive active) {
}
