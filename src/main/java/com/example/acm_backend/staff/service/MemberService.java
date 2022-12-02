package com.example.acm_backend.staff.service;
import com.example.acm_backend.staff.entities.Member;
import com.example.acm_backend.staff.entities.MemberRepo;
import com.example.acm_backend.staff.entities.StaffCategory;
import com.example.acm_backend.staff.entities.StaffCategoryRepo;
import com.example.acm_backend.staff.requests.CreateMemberRequest;
import com.example.acm_backend.staff.requests.CreateStaffCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepo memberRepo;
    public Member createMember(CreateMemberRequest createMemberRequest){
        return memberRepo.save(Member.of(createMemberRequest));
    }
    public List<Member> findAll(){
        return memberRepo.findAll();
    }
    public Member getMember(long id){
        return memberRepo.findById(id);
    }
}


