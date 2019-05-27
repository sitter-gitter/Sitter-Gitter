package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.Appointment;
import com.codeup.sittergitter.models.Review;
import com.codeup.sittergitter.models.User;
import com.codeup.sittergitter.repositories.*;
import com.codeup.sittergitter.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/reviews/create")
    @GetMapping("/reviews/{id}/create")
    public String showCreateReview(@PathVariable Long id, Model model) {
        Appointment appointment = appointmentsRepo.findOne(id);
        model.addAttribute("appointment", appointment);
        model.addAttribute("review", new Review());
        return "reviews/create";
    }

    @PostMapping("/reviews/create")
    public String createReview(@ModelAttribute Review reviewToSaved, @RequestParam Long sitter_id, @RequestParam Long appt_id, @RequestParam(defaultValue = "false") Boolean isRecommended) {
//        reviewToSaved.setAuthor(usersRepo.findOne(1L));
//        Review savedReview = reviewsRepo.save(reviewToSaved);

        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDB = usersRepo.findOne(sessionUser.getId());
        User sitter = usersRepo.findOne(sitter_id);
        Appointment appointment = appointmentsRepo.findOne(appt_id);
        reviewToSaved.setParent(userDB);
        reviewToSaved.setBabysitter(sitter);
        reviewToSaved.setAppointment(appointment);
        reviewToSaved.setIsRecommended(isRecommended);
        Review savedReview = reviewsRepo.save(reviewToSaved);
        appointmentsRepo.updateIsReviewed(appt_id, true);

        //        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        DO NOT DELETE: THIS IS TO SEND NOTIFICATION EMAILS TO THE BABYSITTER
//        emailService.sendReviewNotification(savedReview, "Babysitting Review",
//                "A review has been made on your appointment lasting from " + savedAppt.getStart() + " until " + savedAppt.getEnd()
//                        + " with the following parent: " + savedReview.getParent().getFirstName() + " " + savedReview.getParent().getLastName() + ".");
//        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        return "redirect:/my-acct";
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
    public String editReview(@ModelAttribute Review reviewToBeEdited, @RequestParam Long sitter_id, @RequestParam Long appt_id){
//        User user = usersRepo.findByUsername(username);

        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDB = usersRepo.findOne(sessionUser.getId());
        User sitter = usersRepo.findOne(sitter_id);
        Appointment appointment = appointmentsRepo.findOne(appt_id);

        reviewToBeEdited.setParent(userDB);
        reviewToBeEdited.setBabysitter(sitter);
        reviewToBeEdited.setAppointment(appointment);
        reviewsRepo.save(reviewToBeEdited);
        return "redirect:/my-acct";
    }

    @GetMapping("/reviews/{id}/delete")
    public String deleteReview(@PathVariable Long id){
        Review review = reviewsRepo.getReviewById(id);
        Long appointment = review.getAppointment().getId();
        reviewsRepo.deleteById(id);
        appointmentsRepo.updateIsReviewed(appointment, false);

        return "redirect:/my-acct";
    }

}