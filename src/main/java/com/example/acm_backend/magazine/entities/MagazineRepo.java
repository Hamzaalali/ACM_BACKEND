package com.example.acm_backend.magazine.entities;
import com.example.acm_backend.podcast.entities.Podcast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazineRepo extends JpaRepository<Magazine,Long> {
}
