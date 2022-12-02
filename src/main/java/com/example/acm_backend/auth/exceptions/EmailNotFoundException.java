package com.example.acm_backend.auth.exceptions;

public class EmailNotFoundException extends MyCustomExceptions{
    public EmailNotFoundException(){
        super("Email Not Found!");
    }
}
