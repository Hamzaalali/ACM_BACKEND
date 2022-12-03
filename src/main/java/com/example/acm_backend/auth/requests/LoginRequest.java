package com.example.acm_backend.auth.requests;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
@Data
public class LoginRequest {
    @NotEmpty(message = "Email can't be empty")
    String email;
    @NotEmpty (message = "Password can't be empty")
    String password;
}
