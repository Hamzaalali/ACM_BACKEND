package com.example.acm_backend.staff.controller;
import com.example.acm_backend.auth.annotations.Authorize;
import com.example.acm_backend.staff.entities.Member;
import com.example.acm_backend.staff.entities.StaffCategory;
import com.example.acm_backend.staff.requests.AddMemberToCategoryRequest;
import com.example.acm_backend.staff.requests.CreateStaffCategoryRequest;
import com.example.acm_backend.staff.requests.GetSubCategoriesRequest;
import com.example.acm_backend.staff.service.StaffCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/staff_category")
@Validated
public class StaffCategoryController {
    private final StaffCategoryService staffCategoryService;
    @Authorize(roles = {"ADMIN"})
    @PostMapping("")
    public ResponseEntity<Object> createCategory(@Valid @RequestBody CreateStaffCategoryRequest createStaffCategoryRequest) {
        StaffCategory staffCategory =staffCategoryService.createCategory(createStaffCategoryRequest);
        return new ResponseEntity<>(staffCategory, HttpStatus.ACCEPTED);
    }
    @GetMapping("")
    public ResponseEntity<Object> getCategories() {
        List<StaffCategory> staffCategories =staffCategoryService.findAll();
        return new ResponseEntity<>(staffCategories, HttpStatus.ACCEPTED);
    }
    @GetMapping("sub")
    public ResponseEntity<Object> getSubCategories(@Valid @RequestBody GetSubCategoriesRequest getSubCategoriesRequest) {
        List<StaffCategory> categories =staffCategoryService.findSubCategories(getSubCategoriesRequest);
        return new ResponseEntity<>(categories, HttpStatus.ACCEPTED);
    }
    @GetMapping("{id}/members")
    public ResponseEntity<Object> getCategoryMembers(@PathVariable("id")long categoryId) {
        List<Member> members =staffCategoryService.findCategoryMember(categoryId);
        return new ResponseEntity<>(members, HttpStatus.ACCEPTED);
    }
    @Authorize(roles = {"ADMIN"})
    @PostMapping("/member")
    public ResponseEntity<Object> addMember(@Valid @RequestBody AddMemberToCategoryRequest addMemberToCategoryRequest) {
        staffCategoryService.addMemberToCategory(addMemberToCategoryRequest);
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.ACCEPTED);
    }
}
