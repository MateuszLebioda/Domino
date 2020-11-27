package com.mateusz.lebioda.errors;

public class CannotCreateAreaException extends RuntimeException {
    public CannotCreateAreaException() {
    }

    public CannotCreateAreaException(String message) {
        super(message);
    }
}
