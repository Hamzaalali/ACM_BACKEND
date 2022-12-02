package com.example.acm_backend.staff.entities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepo extends JpaRepository<Member,Long> {
    public Member findById(long id);
}
