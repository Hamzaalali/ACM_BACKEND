package com.example.acm_backend.auth.exceptions;

public class FailedToLogoutException extends MyCustomExceptions{
    public FailedToLogoutException(){
        super("Logout Failed!");
    }
}
