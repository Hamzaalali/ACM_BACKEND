package com.example.acm_backend.staff.service;
import com.example.acm_backend.staff.entities.Member;
import com.example.acm_backend.staff.entities.StaffCategory;
import com.example.acm_backend.staff.entities.StaffCategoryRepo;
import com.example.acm_backend.staff.requests.AddMemberToCategoryRequest;
import com.example.acm_backend.staff.requests.CreateStaffCategoryRequest;
import com.example.acm_backend.staff.requests.GetSubCategoriesRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StaffCategoryService {
    private final StaffCategoryRepo staffCategoryRepo;
    private final MemberService memberService;
    public StaffCategory createCategory(CreateStaffCategoryRequest createStaffCategoryRequest){
        return staffCategoryRepo.save(StaffCategory.of(createStaffCategoryRequest));
    }
    public StaffCategory getCategory(long id){
        return staffCategoryRepo.findById(id);
    }
    public List<StaffCategory> findAll(){
        return staffCategoryRepo.findAll();
    }
    public List<Member> findCategoryMember(long id){
        List<Member> members=getCategory(id).getMembers();
        return members;
    }
    public List<StaffCategory> findSubCategories(GetSubCategoriesRequest getSubCategoriesRequest){
        List<StaffCategory> categories=staffCategoryRepo.findByParentCategory(getCategory(getSubCategoriesRequest.getParentCategoryId()));
        return categories;
    }
    public void addMemberToCategory(AddMemberToCategoryRequest addMemberToCategoryRequest){
        StaffCategory staffCategory=getCategory(addMemberToCategoryRequest.getCategory_id());
        Member member=memberService.getMember(addMemberToCategoryRequest.getMember_id());
        staffCategory.getMembers().add(member);
        staffCategoryRepo.save(staffCategory);
    }
}
