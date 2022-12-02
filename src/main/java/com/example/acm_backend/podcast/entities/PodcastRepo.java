package com.example.acm_backend.podcast.entities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PodcastRepo extends JpaRepository<Podcast,Long> {
}
