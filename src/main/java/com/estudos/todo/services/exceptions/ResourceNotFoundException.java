package com.estudos.todo.services.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public ResourceNotFoundException(Object id) {
        super("User with " + id + " id doesn't exists!");
    }
}
