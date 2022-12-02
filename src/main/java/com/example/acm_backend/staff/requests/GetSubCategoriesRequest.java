package com.example.acm_backend.staff.requests;

import lombok.Data;

@Data
public class GetSubCategoriesRequest {
    long parentCategoryId;
}
