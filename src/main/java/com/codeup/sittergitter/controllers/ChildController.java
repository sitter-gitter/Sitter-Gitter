package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.Child;
import com.codeup.sittergitter.models.User;
import com.codeup.sittergitter.repositories.ChildRepository;
import com.codeup.sittergitter.repositories.SpecificationRepository;
import com.codeup.sittergitter.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
    model.addAttribute("child", new Child());
    model.addAttribute("user", user);
    return "users/updateChildren";
  }

    @PostMapping("/profile/{username}/edit/children")
    public String editUser(@ModelAttribute Child childToSaved
//            @PathVariable String username,
//                           @RequestParam String name,
//                           @RequestParam Date birthdate,
//                           @RequestParam String specialNote
    ) {
//        User user = usersRepo.findByUsername(username);
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDB = usersRepo.findOne(sessionUser.getId());
        childToSaved.setParent(userDB);
        Child savedChild = childrenRepo.save(childToSaved);

//        Child newChild = new Child();

//        newChild.setName(name);
//        newChild.setBirthdate(birthdate);
//        newChild.setSpecialNote(specialNote);
//        newChild.setParent(user);

//        childrenRepo.save(newChild);

//        user.getChildren().add(newChild);

//        usersRepo.save(user);
        return "redirect:/profile/{username}";
    }
}