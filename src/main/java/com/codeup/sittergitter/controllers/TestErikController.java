package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.AvailableTime;
import com.codeup.sittergitter.models.Review;
import com.codeup.sittergitter.models.User;
import com.codeup.sittergitter.repositories.AppointmentRepository;
import com.codeup.sittergitter.repositories.AvailableTimeRepository;
import com.codeup.sittergitter.repositories.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TestErikController {

    private final AvailableTimeRepository availableTimesRepo;
    private final AppointmentRepository appointmentsRepo;
    private final UserRepository usersRepo;

    public TestErikController(AvailableTimeRepository availableTimesRepo, AppointmentRepository appointmentsRepo,
                              UserRepository usersRepo) {
        this.availableTimesRepo = availableTimesRepo;
        this.appointmentsRepo = appointmentsRepo;
        this.usersRepo = usersRepo;
    }

    @PostMapping("/available-times/{id}/edit")
    public String editAvailableTime(@ModelAttribute AvailableTime availableTimeToBeEdited){
        availableTimeToBeEdited.setBabysitter(usersRepo.findOne(1L));
        availableTimesRepo.save(availableTimeToBeEdited);
        return "redirect:/reviews/" + availableTimeToBeEdited.getId();
    }

    @GetMapping("/available-times/{id}/delete")
    public String deleteAvailableTime(@PathVariable Long id){
        availableTimesRepo.deleteById(id);
        return "redirect:/available-times";
    }


}

//    private final UserRepository usersRepo;
//    private final AvailableTimeRepository availRepo;
//    private PasswordEncoder passwordEncoder;
//
//    public TestErikController(UserRepository usersRepo, PasswordEncoder passwordEncoder, AvailableTimeRepository availRepo) {
//        this.usersRepo = usersRepo;
//        this.passwordEncoder = passwordEncoder;
//        this.availRepo = availRepo;
//    }
//
//    @GetMapping("/erik")
////    @ResponseBody
//    public String asdf(){
//        List<AvailableTime> startTimes = availRepo.findByOrderByStartAsc();
//
//        StringUtils.join(startTimes, "|");
//
//        System.out.println(startTimes);
////        for (time : startTimes) {
////
////        }
//
////        startTimes.forEach(time -> System.out.println(time));
//        return "newPageTemplate";
//    }

//    public static void main(String[] args) {
//        AvailableTime availStart = availRepo.findByOrderByStartAsc();
//
//    }
//    // CREATE PROFILE GET
//    @GetMapping("/register")
//    public String showSignupForm(Model model){
//        model.addAttribute("user", new User());
//        return "users/register";
//    }
//
//    // CREATE PROFILE POST
//    @PostMapping("/register")
//    public String saveUser(@ModelAttribute User user){
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        usersRepo.save(user);
//        return "redirect:/login";
//    }
//
//    // READ ALL PROFILES
//    @GetMapping("/profile/index")
//    public String showUsers(Model model) {
//        model.addAttribute("users", usersRepo.findAll());
//        return "users/index";
//    }
//
//    // READ ONE PROFILE
//    @GetMapping("/profile/{username}")
//    public String showUser(@PathVariable String username, Model model){
//        User user = usersRepo.findByUsername(username);
//        model.addAttribute("user", user);
//        return "users/show";
//    }
//
//    // UPDATE PROFILE GET
//    @GetMapping("/profile/{username}/edit")
//    public String showEditUser(@PathVariable String username, Model model) {
//        User user = usersRepo.findByUsername(username);
//        model.addAttribute("user", user);
//        return "users/edit";
//    }
//
//    // UPDATE PROFILE POST
//    @PostMapping("/profile/{username}/edit")
//    public String editUser(@PathVariable String username, @RequestParam String password, @RequestParam String email) {
//        User user = usersRepo.findByUsername(username);
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setEmail(email);
//        usersRepo.save(user);
//        return "redirect:/profile/index";
//    }
//
//    // DELETE PROFILE
//    @PostMapping("/profile/{username}/delete")
//    public String deleteUser(@PathVariable User username) {
////        usersRepo.delete(usersRepo.findByUsername(username));
////        username.getId();
//        usersRepo.delete(username.getId());
////        usersRepo.findOne()
////        usersRepo.deleteByUsername(username);
//        return "redirect:/profile/index";
//    }
//
//    // READ SEARCH FOR BABYSITTERS
//    @GetMapping("/sitters")
//    public String showSitters() {
//        //////////// logic for showing only babysitters here /////////////
//        return "users/sitters";
//    }

