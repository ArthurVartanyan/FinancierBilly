package com.financier.billy.exception.runtime;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}