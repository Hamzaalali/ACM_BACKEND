package com.example.acm_backend.magazine.requests;
import com.example.acm_backend.auth.entities.User;
import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class CreateMagazineRequest {
    @NotEmpty(message = "Podcast Name Required")
    private String podcastName;
    @NotEmpty(message = "Presenter Name Required")
    private String presenterName;
    @NotEmpty(message = "Guest Name Required")
    private String guestName;
    @NotEmpty(message = "Poster Link Required")
    private String posterLink;
    @NotEmpty(message = "Audio Link Required ")
    private String audioLink;
    private User creator;

}
