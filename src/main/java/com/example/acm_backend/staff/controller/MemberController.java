package com.example.acm_backend.staff.controller;
import com.example.acm_backend.auth.annotations.Authorize;
import com.example.acm_backend.auth.entities.User;
import com.example.acm_backend.podcast.entities.Podcast;
import com.example.acm_backend.podcast.requests.CreatePodcastRequest;
import com.example.acm_backend.podcast.service.PodcastService;
import com.example.acm_backend.staff.entities.Member;
import com.example.acm_backend.staff.requests.CreateMemberRequest;
import com.example.acm_backend.staff.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/member")
@Validated
public class MemberController {
    private final MemberService memberService;
    @Authorize(roles = {"ADMIN"})
    @PostMapping("")
    public ResponseEntity<Object> createMember(@Valid @RequestBody CreateMemberRequest createMemberRequest) {
        Member member=memberService.createMember(createMemberRequest);
        return new ResponseEntity<>(member, HttpStatus.ACCEPTED);
    }
    @Authorize(roles = {"ADMIN"})
    @GetMapping("")
    public ResponseEntity<Object> findAll() {
        List<Member> members=memberService.findAll();
        return new ResponseEntity<>(members, HttpStatus.ACCEPTED);
    }
}
