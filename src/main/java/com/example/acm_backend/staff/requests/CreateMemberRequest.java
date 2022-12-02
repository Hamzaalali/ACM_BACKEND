package com.example.acm_backend.staff.requests;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class CreateMemberRequest {
    @NotEmpty(message = "Member Name Required")
    private String name;
    @NotEmpty(message = "Member Email Required")
    private String email;
    @NotEmpty(message = "Member Phone Number Required")
    private String phoneNumber;
    @NotEmpty(message = "Member Student Number Required")
    private String studentNumber;
    @NotEmpty(message = "Member Major Required")
    private String major;
    private String pictureLink;
}
