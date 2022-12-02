package com.example.acm_backend.staff.requests;

import lombok.Data;

@Data
public class AddMemberToCategoryRequest {
    private long category_id;
    private long member_id;
}
