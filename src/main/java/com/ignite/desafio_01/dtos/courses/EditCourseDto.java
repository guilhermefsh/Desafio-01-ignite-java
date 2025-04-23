package com.ignite.desafio_01.dtos.courses;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Optional;
import java.util.UUID;

public record EditCourseDto(@Schema(example = "Fundamentos Next.js") Optional<String> name,
                            @Schema(example = "Formação") Optional<String> category) {
}
