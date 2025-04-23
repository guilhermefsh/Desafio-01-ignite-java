package com.ignite.desafio_01.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public class ErrorResponse{
    @Schema(description = "status", example = "400")
    private int status;
    @Schema(description = "message", example = "Curso não encontrado")
    private String message;

    public ErrorResponse(int status, String message) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
