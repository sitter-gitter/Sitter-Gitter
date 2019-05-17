package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.repositories.AvailableTimeRepository;
import com.codeup.sittergitter.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestDwightController {

    private final AvailableTimeRepository availableTimesRepo;
    private final UserRepository usersRepo;

    public TestDwightController(AvailableTimeRepository availableTimesRepo, UserRepository usersRepo) {
        this.availableTimesRepo = availableTimesRepo;
        this.usersRepo = usersRepo;
    }

    @GetMapping("/available-times")
    public String displayAllAvailTimes(Model model) {
        model.addAttribute("available_times", availableTimesRepo.findAll());
        return "dwight-available-times";
    }

//    @GetMapping("/")
//    public String welcome2(Model model) {
//        model.addAttribute("datetime", new Review());
//        return "home";
//    }

//    @GetMapping("/available-times/{id}/display")
//    public String displayAvailTimesById(@PathVariable long id, Model model) {
//        model.addAttribute("available-times", availableTimesRepository.findAvailableTimesByBabysitter_Id(id));
//        return "dwight-available-times";
//    }


}
