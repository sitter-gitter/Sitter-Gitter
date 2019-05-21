package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.User;
import com.codeup.sittergitter.repositories.ChildRepository;
import com.codeup.sittergitter.repositories.SpecificationRepository;
import com.codeup.sittergitter.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ChildController {

  private final UserRepository usersRepo;
  private final ChildRepository childrenRepo;
  private final SpecificationRepository specificationsRepo;

  public ChildController(UserRepository usersRepo, ChildRepository childrenRepo, SpecificationRepository specificationsRepo) {
      this.usersRepo = usersRepo;
      this.childrenRepo = childrenRepo;
      this.specificationsRepo = specificationsRepo;
  }

  @GetMapping("/profile/{username}/edit/children")
  public String showEditSpecs(@PathVariable String username, Model model) {
    User user = usersRepo.findByUsername(username);
    model.addAttribute("user", user);
    return "users/updateChildren";
  }

}