package com.ignite.desafio_01.dtos.courses;

import java.util.Optional;
import java.util.UUID;

public record EditCourseDto(Optional<String> name, Optional<String> category) {
}
