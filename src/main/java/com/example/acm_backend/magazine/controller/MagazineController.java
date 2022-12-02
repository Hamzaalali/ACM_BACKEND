package com.example.acm_backend.magazine.controller;
import com.example.acm_backend.auth.annotations.Authenticate;
import com.example.acm_backend.auth.annotations.Authorize;
import com.example.acm_backend.auth.entities.User;
import com.example.acm_backend.podcast.entities.Podcast;
import com.example.acm_backend.podcast.requests.CreatePodcastRequest;
import com.example.acm_backend.podcast.service.PodcastService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/magazine")
@Validated
public class MagazineController {
    private final PodcastService podcastService;

    @Authenticate
    @Authorize(roles = {"ADMIN"})
    @PostMapping("")
    public ResponseEntity<Object> createPodcast(HttpServletRequest request, @Valid @RequestBody CreatePodcastRequest createPodcastRequest) {
        User user= (User) request.getAttribute("user");
        createPodcastRequest.setCreator(user);
        Podcast podcast=podcastService.createPodcast(createPodcastRequest);
        return new ResponseEntity<>(podcast, HttpStatus.ACCEPTED);
    }
}