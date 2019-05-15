package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.Review;
import com.codeup.sittergitter.models.User;
import com.codeup.sittergitter.repositories.ReviewRepository;
import com.codeup.sittergitter.repositories.UserRepository;
import com.codeup.sittergitter.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReviewController {

    private final ReviewRepository reviewsRepo;
    private final UserRepository usersRepo;
    private EmailService emailService;

    public ReviewController(ReviewRepository reviewsRepo, UserRepository usersRepo, EmailService emailService) {
        this.reviewsRepo = reviewsRepo;
        this.usersRepo = usersRepo;
        this.emailService = emailService;
    }

    @GetMapping("/reviews")
    public String showReviews(Model model) {
        model.addAttribute("reviews", reviewsRepo.findAll());
        return "reviews/index";
    }

    @GetMapping("/reviews/{id}")
    public String showReview(@PathVariable Long id, Model model) {
        User author = usersRepo.findOne(1L);
        model.addAttribute("author", author);
        //////////////////////////// refactor ^

        Review review = reviewsRepo.findOne(id);
        model.addAttribute("review", review);
        return "reviews/show";
    }

    @GetMapping("/reviews/create")
    public String showCreateReview(Model model) {
        model.addAttribute("review", new Review());
        return "reviews/create";
    }

    @PostMapping("/reviews/create")
    public String createReview(@ModelAttribute Review reviewToSaved) {
//        reviewToSaved.setAuthor(usersRepo.findOne(1L));
//        Review savedReview = reviewsRepo.save(reviewToSaved);

        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDB = usersRepo.findOne(sessionUser.getId());
        reviewToSaved.setAuthor(userDB);
        Review savedReview = reviewsRepo.save(reviewToSaved);

//        emailService.prepareAndSend(savedReview, "Review has been created", "The review has been created successfully
//        and " + "you can find it with the ID of " + savedReview.getId());
        return "redirect:/reviews/" + savedReview.getId();
    }

    @GetMapping("/reviews/{id}/edit")
    public String showEditReview(@PathVariable Long id, Model model){
        Review review = reviewsRepo.findOne(id);
        User user = usersRepo.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("review", review);
        return "reviews/edit";
    }

    @PostMapping("/reviews/{id}/edit")
    public String editReview(@ModelAttribute Review reviewToBeEdited){
        reviewToBeEdited.setAuthor(usersRepo.findOne(1L));
        reviewsRepo.save(reviewToBeEdited);
        return "redirect:/reviews/" + reviewToBeEdited.getId();
    }

    @GetMapping("/reviews/{id}/delete")
    public String deleteReview(@PathVariable Long id){
        reviewsRepo.deleteById(id);
        return "redirect:/reviews";
    }

}