package com.example.acm_backend.staff.requests;

import lombok.Data;

@Data
public class AddMemberToCategoryRequest {
    long category_id;
    long member_id;
}
