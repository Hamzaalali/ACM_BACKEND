package com.example.acm_backend.podcast.service;
import com.example.acm_backend.podcast.entities.Podcast;
import com.example.acm_backend.podcast.entities.PodcastRepo;
import com.example.acm_backend.podcast.requests.CreatePodcastRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PodcastService {
    private final PodcastRepo podcastRepo;
    public Podcast createPodcast(CreatePodcastRequest createPodcastRequest){
        return podcastRepo.save(Podcast.of(createPodcastRequest));
    }
}
