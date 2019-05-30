package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // CREATE PROFILE
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("user", new User());
        return "users/select-acct-type";
    }

    @GetMapping("/home")
    public String home2() {
        return "users/select-acct-type";
    }

}
