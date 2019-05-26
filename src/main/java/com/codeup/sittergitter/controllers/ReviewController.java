package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.Review;
import com.codeup.sittergitter.models.User;
import com.codeup.sittergitter.repositories.*;
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
    private final AppointmentRepository appointmentsRepo;
    private final AvailableTimeRepository availableTimesRepo;
    private final ChildRepository childrenRepo;
    private final SpecificationRepository specificationsRepo;
    private EmailService emailService; // uncomment email section in postmapping for reviews/create in order to
    // function //

    public ReviewController(ReviewRepository reviewsRepo, UserRepository usersRepo, AppointmentRepository appointmentsRepo, AvailableTimeRepository availableTimesRepo, ChildRepository childrenRepo, SpecificationRepository specificationsRepo, EmailService emailService) {
        this.reviewsRepo = reviewsRepo;
        this.usersRepo = usersRepo;
        this.appointmentsRepo = appointmentsRepo;
        this.availableTimesRepo = availableTimesRepo;
        this.childrenRepo = childrenRepo;
        this.specificationsRepo = specificationsRepo;
        this.emailService = emailService;
    }

    @GetMapping("/reviews")
    public String showReviews(Model model) {
        model.addAttribute("reviews", reviewsRepo.findAll());
        return "reviews/index";
    }

    @GetMapping("/reviews/{id}")
    public String showReview(@PathVariable Long id, Model model) {
//        User parent = usersRepo.findOne(1L);
//        model.addAttribute("parent", parent);
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
        reviewToSaved.setParent(userDB);
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
//        User user = usersRepo.findByUsername(username);

        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDB = usersRepo.findOne(sessionUser.getId());



        reviewToBeEdited.setParent(userDB);
        reviewsRepo.save(reviewToBeEdited);
        return "redirect:/my-acct";
    }

    @GetMapping("/reviews/{id}/delete")
    public String deleteReview(@PathVariable Long id){
        reviewsRepo.deleteById(id);
        return "redirect:/my-acct";
    }

}