package com.ignite.desafio_01.exceptions;

import java.util.List;

public class ValidationErrorResponse extends ErrorResponse {
    private List<FieldErrorItem> errors;

    public ValidationErrorResponse(int status, String message, List<FieldErrorItem> errors) {
        super(status, message);
        this.errors = errors;
    }

    public static class FieldErrorItem {
        private String field;
        private String message;

        public FieldErrorItem() {}

        public FieldErrorItem(String field, String message) {
            this.field = field;
            this.message = message;
        }
    }

    public List<FieldErrorItem> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldErrorItem> errors) {
        this.errors = errors;
    }
}
