package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.User;
import com.codeup.sittergitter.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserRepository usersRepo;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository usersRepo, PasswordEncoder passwordEncoder) {
        this.usersRepo = usersRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersRepo.save(user);
        return "redirect:/login";
    }

    @GetMapping("/profile/index")
    public String showUsers(Model model) {
        model.addAttribute("users", usersRepo.findAll());
        return "users/index";
    }

    @GetMapping("profile/{username}")
    public String showUser(@PathVariable String username, Model model){
        User user = usersRepo.findByUsername(username);
        model.addAttribute("user", user);
        return "users/show";
    }

    @GetMapping("/profile/{username}/edit")
    public String showEditUser(@PathVariable String username, Model model) {
        User user = usersRepo.findByUsername(username);
        model.addAttribute("user", user);
        return "users/edit";
    }

    @PostMapping("/profile/{username}/edit")
    public String editUser(@PathVariable String username, @RequestParam String password, @RequestParam String email) {
        User user = usersRepo.findByUsername(username);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        usersRepo.save(user);
        return "redirect:/profile/index";
    }

    @GetMapping("/users/{username}/delete")
    public String deleteUser(@PathVariable String username) {
        usersRepo.delete(usersRepo.findByUsername(username));
        return "redirect:/profile/index";
    }

}