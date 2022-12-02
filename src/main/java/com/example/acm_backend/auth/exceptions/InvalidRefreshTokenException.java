package com.example.acm_backend.auth.exceptions;

public class InvalidRefreshTokenException extends MyCustomExceptions{
    public InvalidRefreshTokenException() {
        super("Invalid refresh Token!");
    }
}
