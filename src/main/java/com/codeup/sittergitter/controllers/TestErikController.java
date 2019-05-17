//package com.codeup.sittergitter.controllers;
//
//import com.codeup.sittergitter.models.User;
//import com.codeup.sittergitter.repositories.UserRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class TestErikController {
//
//    private final UserRepository usersRepo;
//    private PasswordEncoder passwordEncoder;
//
//    public TestErikController(UserRepository usersRepo, PasswordEncoder passwordEncoder) {
//        this.usersRepo = usersRepo;
//        this.passwordEncoder = passwordEncoder;
//    }
//
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
//
//}