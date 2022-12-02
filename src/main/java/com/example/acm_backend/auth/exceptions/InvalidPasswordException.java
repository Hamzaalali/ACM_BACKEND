package com.example.acm_backend.auth.exceptions;

public class InvalidPasswordException extends MyCustomExceptions{

    public InvalidPasswordException(){
        super("Invalid Password!");
    }
}
