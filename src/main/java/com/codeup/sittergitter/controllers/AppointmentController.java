package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.Appointment;
import com.codeup.sittergitter.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppointmentController {

    private final ReviewRepository reviewsRepo;
    private final UserRepository usersRepo;
    private final AppointmentRepository appointmentsRepo;
    private final AvailableTimeRepository availableTimesRepo;
    private final ChildRepository childrenRepo;
    private final SpecificationRepository specificationsRepo;

    public AppointmentController(ReviewRepository reviewsRepo, UserRepository usersRepo, AppointmentRepository appointmentsRepo, AvailableTimeRepository availableTimesRepo, ChildRepository childrenRepo, SpecificationRepository specificationsRepo) {
        this.reviewsRepo = reviewsRepo;
        this.usersRepo = usersRepo;
        this.appointmentsRepo = appointmentsRepo;
        this.availableTimesRepo = availableTimesRepo;
        this.childrenRepo = childrenRepo;
        this.specificationsRepo = specificationsRepo;
    }

    // READ ALL APPOINTMENTS
    @GetMapping("/appointments")
    public String showAppointments(Model model) {
        model.addAttribute("appointments", appointmentsRepo.findAll());
        return "appointments/showAppointments";
    }

    // READ APPOINTMENT BY ID
    @GetMapping("/appointments/{id}")
    public String showAppointment(@PathVariable Long id, Model model) {

        Appointment appointment = appointmentsRepo.findOne(id);
        model.addAttribute("appointment", appointment);

        return "appointments/showAppointment";
    }
}