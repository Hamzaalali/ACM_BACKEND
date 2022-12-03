package com.example.acm_backend.auth.requests;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
@Data
public class RefreshRequest {
    @NotEmpty(message = "Refresh Token Can't Be Empty")
    String refreshToken;
}
