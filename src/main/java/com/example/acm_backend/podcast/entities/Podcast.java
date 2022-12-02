package com.example.acm_backend.podcast.entities;
import com.example.acm_backend.auth.entities.User;
import com.example.acm_backend.podcast.requests.CreatePodcastRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
public class Podcast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String podcastName;
    private String presenterName;
    private String guestName;
    private String posterLink;
    private String audioLink;
    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User creator;

    public static Podcast of(CreatePodcastRequest createPodcastRequest){
        Podcast podcast=new Podcast();
        podcast.podcastName=createPodcastRequest.getPodcastName();
        podcast.presenterName=createPodcastRequest.getPresenterName();
        podcast.guestName=createPodcastRequest.getGuestName();
        podcast.audioLink=createPodcastRequest.getAudioLink();
        podcast.posterLink=createPodcastRequest.getPosterLink();
        podcast.creator=createPodcastRequest.getCreator();
        return podcast;
    }
}
