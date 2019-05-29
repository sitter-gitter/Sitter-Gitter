package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.Specification;
import com.codeup.sittergitter.models.User;
import com.codeup.sittergitter.repositories.SpecificationRepository;
import com.codeup.sittergitter.repositories.UserRepository;
import org.hibernate.validator.constraints.URL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AuthenticationController {

    private final UserRepository usersRepo;
    private final SpecificationRepository specsRepo;

    public AuthenticationController(UserRepository usersRepo, SpecificationRepository specsRepo) {
        this.usersRepo = usersRepo;
        this.specsRepo = specsRepo;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login";
    }

    @PostMapping("/login")
    public String loggedIn(@RequestParam String username) {
        User user = usersRepo.findByUsername(username);

//        if (user.getisBabysitter()) {
//            Specification userSpecs = user.getSpecifications();
//            if (userSpecs.getHasCprTraining().isEmpty())
//                return "redirect:/editSpecs";
//        } else if (!user.getisBabysitter()) {
//            List userChildren = user.getChildren();
//            if (userChildren.isEmpty())
//                return "redirect:/editChildren";
//        }

        return "redirect:/my-acct";
    }
}