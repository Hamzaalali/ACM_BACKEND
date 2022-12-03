package com.example.acm_backend.podcast.controller;
import com.example.acm_backend.auth.annotations.Authorize;
import com.example.acm_backend.auth.entities.User;
import com.example.acm_backend.podcast.entities.Podcast;
import com.example.acm_backend.podcast.requests.CreatePodcastRequest;
import com.example.acm_backend.podcast.service.PodcastService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/podcast")
@Validated
public class PodcastController {
    private final PodcastService podcastService;
    @Authorize(roles = {"ADMIN"})
    @PostMapping("")
    public ResponseEntity<Object> createPodcast(HttpServletRequest request, @Valid @RequestBody CreatePodcastRequest createPodcastRequest) {
        User user= (User) request.getAttribute("user");
        createPodcastRequest.setCreator(user);
        Podcast podcast=podcastService.createPodcast(createPodcastRequest);
        return new ResponseEntity<>(podcast, HttpStatus.ACCEPTED);
    }
}
