package me.mrodriguezdev.apibiblioteca.infraestructure.exceptions;

import me.mrodriguezdev.apibiblioteca.domains.models.CustomExceptionResponse;

public abstract class CustomException extends RuntimeException{
    private final CustomExceptionResponse<?> response;

    public CustomException(CustomExceptionResponse<?> response) {
        this.response = response;
    }

    public CustomException(String message, Throwable cause, CustomExceptionResponse<?> response) {
        super(message, cause);
        this.response = response;
    }

    public CustomException(String message, CustomExceptionResponse<?> response) {
        super(message);
        this.response = response;
    }

    public CustomExceptionResponse<?> getResponse() {
        return response;
    }
}
