package com.example.acm_backend.staff.entities;
import com.example.acm_backend.auth.entities.User;
import com.example.acm_backend.staff.requests.CreateMemberRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String studentNumber;
    private String major;
    private String pictureLink;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "members")
    @JsonIgnore
    private List<StaffCategory> staffCategories;
    public static Member of(CreateMemberRequest createMemberRequest){
        Member member=new Member();
        member.name=createMemberRequest.getName();
        member.email=createMemberRequest.getEmail();
        member.phoneNumber=createMemberRequest.getPhoneNumber();
        member.studentNumber=createMemberRequest.getStudentNumber();
        member.major=createMemberRequest.getMajor();
        member.pictureLink=createMemberRequest.getPictureLink();
        return member;
    }
}