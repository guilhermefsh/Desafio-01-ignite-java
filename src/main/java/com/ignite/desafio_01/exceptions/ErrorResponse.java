package com.ignite.desafio_01.exceptions;

import java.time.LocalDateTime;

public class ErrorResponse{
    private int status;
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
