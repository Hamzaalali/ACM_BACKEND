package com.example.acm_backend.magazine.requests;
import com.example.acm_backend.auth.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;

@Data
public class CreateMagazineRequest {
    @NotEmpty(message = "Magazine Name Required")
    String magazineName;
    @NotNull(message = "Release Date Required")
    Date releaseDate;
    User creator;

}
