package com.example.acm_backend.staff.entities;
import com.example.acm_backend.auth.entities.Role;
import com.example.acm_backend.staff.requests.CreateStaffCategoryRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class StaffCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    private boolean isLeaf;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonIgnore
    private StaffCategory parentCategory;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "member_staff_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id"))
    @JsonIgnore
    private List<Member> members;

    public static StaffCategory of(CreateStaffCategoryRequest createStaffCategoryRequest){
        StaffCategory staffCategory=new StaffCategory();
        staffCategory.categoryName=createStaffCategoryRequest.getCategoryName();
        staffCategory.parentCategory=createStaffCategoryRequest.getParentCategory();
        staffCategory.isLeaf=createStaffCategoryRequest.isLeaf();
        return staffCategory;
    }
}