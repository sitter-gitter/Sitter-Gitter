package com.codeup.sittergitter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContactController {
    @GetMapping("/contact")
    public String showContact() {

        return "contact";
    }
}