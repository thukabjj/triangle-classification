package com.triangle.classification.usecase.authentication.exception;

public class InvalidCredentialsException extends RuntimeException {

    public InvalidCredentialsException(String msg) {
        super(msg);
    }
}
