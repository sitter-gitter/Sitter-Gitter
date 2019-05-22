package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.Child;
import com.codeup.sittergitter.models.Specification;
import com.codeup.sittergitter.models.User;
import com.codeup.sittergitter.repositories.SpecificationRepository;
import com.codeup.sittergitter.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SpecificationController {

  private final UserRepository usersRepo;
  private final SpecificationRepository specificationsRepo;

  public SpecificationController(UserRepository usersRepo, SpecificationRepository specificationsRepo) {
    this.usersRepo = usersRepo;
    this.specificationsRepo = specificationsRepo;
  }

  @GetMapping("/profile/{username}/create/specifications")
  public String showCreateSpecifications(Model model) {
    model.addAttribute("specification", new Specification());
    return "users/updateSpecifications";
  }

  @PostMapping("/profile/{username}/create/specifications")
  public String createSpecifications(@ModelAttribute Specification specificationToSaved) {
    User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User userDB = usersRepo.findOne(sessionUser.getId());
    specificationToSaved.setBabysitter(userDB);
    return "redirect:/profile/{username}";
  }

  @GetMapping("/profile/{username}/edit/specifications")
  public String showEditSpecs(@PathVariable String username, Model model) {
    User user = usersRepo.findByUsername(username);
    List<Specification> specification = specificationsRepo.findByBabysitterUsername(username);
    model.addAttribute("specification", specification);
    model.addAttribute("user", user);
    return "users/updateSpecifications";
  }

  @PostMapping("/profile/{username}/edit/specifications")
  public String editUser(@ModelAttribute Specification specificationToSaved) {
    User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User userDB = usersRepo.findOne(sessionUser.getId());
    specificationToSaved.setBabysitter(userDB);
    Specification savedSpecification = specificationsRepo.save(specificationToSaved);

    return "redirect:/profile/{username}";
  }
}
