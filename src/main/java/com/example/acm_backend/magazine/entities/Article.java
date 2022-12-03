package com.example.acm_backend.magazine.entities;

import com.example.acm_backend.auth.entities.User;
import com.example.acm_backend.auth.entities.UserTokens;
import com.example.acm_backend.staff.entities.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @ManyToOne()
    @JoinColumn(name = "magazine_id", nullable = false)
    private Magazine magazine;
    @OneToOne
    @MapsId
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member member;
}
