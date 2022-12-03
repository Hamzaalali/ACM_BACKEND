package com.example.acm_backend.magazine.entities;
import com.example.acm_backend.auth.entities.User;
import com.example.acm_backend.magazine.requests.CreateMagazineRequest;
import com.example.acm_backend.podcast.entities.Podcast;
import com.example.acm_backend.podcast.requests.CreatePodcastRequest;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Magazine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String magazineName;
    private Date releaseDate;
    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User creator;

    @OneToMany(mappedBy = "magazine")
    private List<Article>articles;
    public static Magazine of(CreateMagazineRequest createMagazineRequest){
        Magazine magazine=new Magazine();
        magazine.magazineName=createMagazineRequest.getMagazineName();
        magazine.releaseDate=createMagazineRequest.getReleaseDate();
        magazine.creator=createMagazineRequest.getCreator();
        return magazine;
    }
}
