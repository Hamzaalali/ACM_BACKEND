package com.example.acm_backend.magazine.controller;
import com.example.acm_backend.auth.annotations.Authenticate;
import com.example.acm_backend.auth.annotations.Authorize;
import com.example.acm_backend.auth.entities.User;
import com.example.acm_backend.magazine.entities.Magazine;
import com.example.acm_backend.magazine.requests.CreateMagazineRequest;
import com.example.acm_backend.magazine.service.MagazineService;
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
@RequestMapping(path = "/magazine")
@Validated
public class MagazineController {
    private final MagazineService magazineService;
    @Authenticate
    @Authorize(roles = {"ADMIN"})
    @PostMapping("")
    public ResponseEntity<Object> createMagazine(HttpServletRequest request,@Valid @RequestBody   CreateMagazineRequest createMagazineRequest) {
        User user= (User) request.getAttribute("user");
        createMagazineRequest.setCreator(user);
        Magazine magazine=magazineService.createMagazine(createMagazineRequest);
        return new ResponseEntity<>(magazine, HttpStatus.ACCEPTED);
    }
}
