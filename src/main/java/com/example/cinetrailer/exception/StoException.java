package com.example.cinetrailer.exception;

public class StoException extends RuntimeException {
    public StoException(String message) {
        super(message);
    }

    public StoException(String message, Throwable exception) {
        super(message, exception);
    }
}
