package me.mrodriguezdev.apibiblioteca.infraestructure.exceptions;

import me.mrodriguezdev.apibiblioteca.domains.models.CustomExceptionResponse;

public class NotFoundException extends CustomException{
    public NotFoundException() {
        super("Not Found", new CustomExceptionResponse<>("Not Found", 404));
    }

    public NotFoundException(String message) {
        super(message, new CustomExceptionResponse<>(message, 404));
    }

    public NotFoundException(CustomExceptionResponse<?> response) {
        super(response);
    }
}
