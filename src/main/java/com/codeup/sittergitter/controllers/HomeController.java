package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.Review;
import com.codeup.sittergitter.models.User;
import com.codeup.sittergitter.repositories.ReviewRepository;
import com.codeup.sittergitter.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final ReviewRepository reviewsRepo;
    private final UserRepository usersRepo;
//    private EmailService emailService;

    public HomeController(ReviewRepository reviewsRepo, UserRepository usersRepo) {
        this.reviewsRepo = reviewsRepo;
        this.usersRepo = usersRepo;
    }

    @GetMapping("/")
    public String welcome() {
        return "home";
    }

    @GetMapping("/home/{name}")
    public String welcome(@PathVariable String name, Model viewModel) {
        viewModel.addAttribute("name", name);
        return "home";
    }

    @GetMapping("/home")
    public String welcome2(Model model) {
        model.addAttribute("datetime", new Review());
        return "home";
    }

    @PostMapping("/home")
    public String datepicker(@ModelAttribute Review reviewToSaved){
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDB = usersRepo.findOne(sessionUser.getId());
        reviewToSaved.setAuthor(userDB);
        Review savedReview = reviewsRepo.save(reviewToSaved);


        System.out.println(savedReview.getBody());





//        model.addAttribute("datepicker1", datepicker1);
//        model.addAttribute("timepicker1", timepicker1);
//        model.addAttribute("datepicker2", datepicker2);
//        model.addAttribute("timepicker2", timepicker2);
//        System.out.println("" + datepicker1 + timepicker1 + datepicker2 + timepicker2);
//        return "home";
        return "redirect:/reviews/" + savedReview.getId();

    }
}
