package com.example.acm_backend.staff.requests;

import com.example.acm_backend.staff.entities.StaffCategory;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateStaffCategoryRequest {
    @NotEmpty(message = "Category Name Required")
    String categoryName;
    StaffCategory parentCategory;
    boolean isLeaf;
}
