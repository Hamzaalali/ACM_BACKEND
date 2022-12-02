package com.example.acm_backend.auth.exceptions;

public class UnauthorizedAccessException extends RuntimeException{
    public UnauthorizedAccessException(){
        super("Unauthorized Access!");
    }
}
