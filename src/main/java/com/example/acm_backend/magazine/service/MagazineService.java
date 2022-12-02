package com.example.acm_backend.magazine.service;
import com.example.acm_backend.podcast.entities.Podcast;
import com.example.acm_backend.podcast.entities.PodcastRepo;
import com.example.acm_backend.podcast.requests.CreatePodcastRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MagazineService {
    private final PodcastRepo podcastRepo;
    public Podcast createPodcast(CreatePodcastRequest createPodcastRequest){
        return podcastRepo.save(Podcast.of(createPodcastRequest));
    }
}
