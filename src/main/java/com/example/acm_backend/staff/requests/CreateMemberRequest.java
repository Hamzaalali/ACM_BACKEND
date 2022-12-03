package com.example.acm_backend.staff.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class CreateMemberRequest {
    @NotEmpty(message = "Member Name Required")
    String name;
    @NotEmpty(message = "Member Email Required")
    String email;
    @NotEmpty(message = "Member Phone Number Required")
    String phoneNumber;
    @NotEmpty(message = "Member Student Number Required")
    String studentNumber;
    @NotEmpty(message = "Member Major Required")
    String major;
    String pictureLink;
}
