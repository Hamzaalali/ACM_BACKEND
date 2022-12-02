package com.example.acm_backend.auth.exceptions;

public class InvalidRoleIdException extends MyCustomExceptions{
    public InvalidRoleIdException(){
        super("Invalid Role ID!");
    }
}
