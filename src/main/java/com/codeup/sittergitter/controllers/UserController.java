package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.EducationLevel;
import com.codeup.sittergitter.models.Specification;
import com.codeup.sittergitter.models.User;
import com.codeup.sittergitter.repositories.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final ReviewRepository reviewsRepo;
    private final UserRepository usersRepo;
    private final AppointmentRepository appointmentsRepo;
    private final AvailableTimeRepository availableTimesRepo;
    private final ChildRepository childrenRepo;
    private final SpecificationRepository specificationsRepo;
    private final PasswordEncoder passwordEncoder;

    public UserController(ReviewRepository reviewsRepo, UserRepository usersRepo, AppointmentRepository appointmentsRepo, AvailableTimeRepository availableTimesRepo, ChildRepository childrenRepo, SpecificationRepository specificationsRepo, PasswordEncoder passwordEncoder) {
        this.reviewsRepo = reviewsRepo;
        this.usersRepo = usersRepo;
        this.appointmentsRepo = appointmentsRepo;
        this.availableTimesRepo = availableTimesRepo;
        this.childrenRepo = childrenRepo;
        this.specificationsRepo = specificationsRepo;
        this.passwordEncoder = passwordEncoder;
    }

//    public UserController(UserRepository usersRepo, PasswordEncoder passwordEncoder) {
//        this.usersRepo = usersRepo;
//        this.passwordEncoder = passwordEncoder;
//    }

    // CREATE PROFILE GET
    @GetMapping("/register")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "users/register";
    }

    // CREATE PROFILE POST
    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user,
        @RequestParam(name = "firstName") String firstName,
        @RequestParam(name = "lastName") String lastName,
        @RequestParam(name = "username") String username,
        @RequestParam(name = "password") String password,
        @RequestParam(name = "email") String email,
        @RequestParam(name = "streetAddr") String streetAddr,
        @RequestParam(name = "city") String city,
        @RequestParam(name = "zipCode") String zipCode
    ) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setUsername(username);
            user.setEmail(email);
            user.setStreetAddr(streetAddr);
            user.setCity(city);
            user.setState("TX");
            user.setZipCode(zipCode);

            String hash = passwordEncoder.encode(password);
            user.setPassword(hash);
        usersRepo.save(user);
        return "redirect:/login";
    }

    // READ ALL PROFILES
    @GetMapping("/profile/index")
    public String showUsers(Model model) {
        model.addAttribute("users", usersRepo.findAll());
        return "users/index";
    }

    // READ ONE PROFILE
    @GetMapping("/profile/{username}")
    public String showUser(@PathVariable String username, Model model) {
        User user = usersRepo.findByUsername(username);
        // get appts for user with appts repo
        model.addAttribute("user", user);
        return "users/show";
    }

    // UPDATE PROFILE GET
    @GetMapping("/profile/{username}/edit")
    public String showEditUser(@PathVariable String username, Model model) {
        User user = usersRepo.findByUsername(username);
        model.addAttribute("user", user);
        return "users/edit";
    }

    // UPDATE PROFILE POST
    @PostMapping("/profile/{username}/edit")
    public String editUser(@PathVariable String username, @RequestParam String password, @RequestParam String email) {
        User user = usersRepo.findByUsername(username);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        usersRepo.save(user);
        return "redirect:/profile/index";
    }

    // DELETE PROFILE
    @PostMapping("/profile/{username}/delete")
    public String deleteUser(@PathVariable User username) {
//        usersRepo.delete(usersRepo.findByUsername(username));
//        username.getId();
        usersRepo.delete(username.getId());
//        usersRepo.findOne()
//        usersRepo.deleteByUsername(username);
        return "redirect:/profile/index";
    }

    // READ SEARCH FOR BABYSITTERS
    @GetMapping("/sitters")
    public String showSitters() {
        //////////// logic for showing only babysitters here /////////////
        return "users/sitters";
    }

}