package me.mrodriguezdev.apibiblioteca.infraestructure.exceptions;

import me.mrodriguezdev.apibiblioteca.domains.models.CustomExceptionResponse;

public class InternalServerErrorException extends CustomException {
    public InternalServerErrorException() {
        super("Internal Server error", new CustomExceptionResponse<>("Internal Server error",500));
    }

    public InternalServerErrorException(String message) {
        super(message, new CustomExceptionResponse<>(message, 500));
    }

    public InternalServerErrorException(CustomExceptionResponse<?> response) {
        super(response);
    }
}
