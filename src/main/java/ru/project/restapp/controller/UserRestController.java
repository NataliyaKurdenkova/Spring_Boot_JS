package ru.project.restapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.restapp.model.User;
import ru.project.restapp.service.UserServiceImpl;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserRestController {

    private final UserServiceImpl userService;

    @Autowired
    public UserRestController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/profile_user")
    public User getUserProfile(Principal principal) {
        return userService.findByEmail(principal.getName());
    }
}
