package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.Review;
import com.codeup.sittergitter.models.User;
import com.codeup.sittergitter.repositories.ReviewRepository;
import com.codeup.sittergitter.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ErrorController {

    private final ReviewRepository reviewsRepo;
    private final UserRepository usersRepo;

    public ErrorController(ReviewRepository reviewsRepo, UserRepository usersRepo) {
        this.reviewsRepo = reviewsRepo;
        this.usersRepo = usersRepo;
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @PostMapping("/error")
    public String error2(){
        return "error";
    }
}
