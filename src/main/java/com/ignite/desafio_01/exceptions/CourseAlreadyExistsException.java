package com.ignite.desafio_01.exceptions;

public class CourseAlreadyExistsException extends RuntimeException {
    public CourseAlreadyExistsException() {
        super("Curso já existe, escolha outro nome e tente novamente");
    }
}
