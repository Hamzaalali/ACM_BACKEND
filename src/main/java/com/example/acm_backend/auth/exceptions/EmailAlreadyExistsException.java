package com.example.acm_backend.auth.exceptions;

public class EmailAlreadyExistsException extends MyCustomExceptions{
    public EmailAlreadyExistsException(){
        super("Email Already Exists!");
    }
}
