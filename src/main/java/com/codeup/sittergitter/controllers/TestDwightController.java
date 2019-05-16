package com.codeup.sittergitter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestDwightController {

    @GetMapping("/FunctionalTesting/Dwight")
    @ResponseBody
    public String displayAvailTimes() {
        return "test this site";
    }

}
