package com.example.acm_backend.magazine.service;
import com.example.acm_backend.magazine.entities.Magazine;
import com.example.acm_backend.magazine.entities.MagazineRepo;
import com.example.acm_backend.magazine.requests.CreateMagazineRequest;
import com.example.acm_backend.podcast.entities.Podcast;
import com.example.acm_backend.podcast.entities.PodcastRepo;
import com.example.acm_backend.podcast.requests.CreatePodcastRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MagazineService {
    private final MagazineRepo magazineRepo;
    public Magazine createMagazine(CreateMagazineRequest createMagazineRequest){
        return magazineRepo.save(Magazine.of(createMagazineRequest));
    }
}
