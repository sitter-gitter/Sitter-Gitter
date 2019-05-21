package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.Specification;
import com.codeup.sittergitter.models.User;
import com.codeup.sittergitter.repositories.SpecificationRepository;
import com.codeup.sittergitter.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SpecificationController {

  private final UserRepository usersRepo;
  private final SpecificationRepository specificationsRepo;

  public SpecificationController(UserRepository usersRepo, SpecificationRepository specificationsRepo) {
    this.usersRepo = usersRepo;
    this.specificationsRepo = specificationsRepo;
  }

  @GetMapping("/users/{username}/edit/specifications")
  public String showEditSpecs(@PathVariable String username, Model model) {
    User user = usersRepo.findByUsername(username);
    model.addAttribute("user", user);
    return "users/edit-specifications";
  }
}