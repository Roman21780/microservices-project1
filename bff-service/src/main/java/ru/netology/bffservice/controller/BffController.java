package ru.netology.bffservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.bffservice.model.UserProfile;
import ru.netology.bffservice.service.UserProfileService;


@RestController
@RequestMapping("/api/site-bff")
public class BffController {

    private final UserProfileService userProfileService;

    public BffController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping("/user/{userId}")
    public UserProfile getUserProfile(@PathVariable Long userId) {
        return userProfileService.getUserProfile(userId);
    }
}
