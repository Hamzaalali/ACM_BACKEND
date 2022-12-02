package com.example.acm_backend.magazine.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "magazine_id", nullable = false)
    private Magazine magazine;

}
