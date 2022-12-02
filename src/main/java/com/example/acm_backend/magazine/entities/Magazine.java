package com.example.acm_backend.magazine.entities;
import com.example.acm_backend.auth.entities.User;
import com.example.acm_backend.magazine.requests.CreateMagazineRequest;
import com.example.acm_backend.podcast.entities.Podcast;
import com.example.acm_backend.podcast.requests.CreatePodcastRequest;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Magazine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String magazineName;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User creator;


    public static Magazine of(CreateMagazineRequest createMagazineRequest){
        Magazine podcast=new Magazine();
        return podcast;
    }
}
