package com.example.acm_backend.staff.requests;

import com.example.acm_backend.staff.entities.StaffCategory;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
@Data
public class CreateStaffCategoryRequest {
    @NotEmpty(message = "Category Name Required")
    private String categoryName;
    private StaffCategory parentCategory;
    private boolean isLeaf;
}
