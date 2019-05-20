package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.Appointment;
import com.codeup.sittergitter.models.AvailableTime;
import com.codeup.sittergitter.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Calendar;

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

        // CREATE APPOINTMENT TIME GET
        @GetMapping("/appointments/create")
        public String parentChoices1(Model model) {
            model.addAttribute("datetime", new Appointment());
            return "appointments/createAppointment";
        }

        // CREATE APPOINTMENT TIME POST
        @PostMapping("/appointments/create")
        public String enterApptTime(@RequestParam String datepicker1, @RequestParam String timepicker1, @RequestParam String datepicker2, @RequestParam String timepicker2) {
            Appointment newApptTime = new Appointment();

            String startTime = datepicker1 + " " + timepicker1 + ":00.000";
            Timestamp startTimeStamp = Timestamp.valueOf(startTime);
            String endTime = datepicker2 + " " + timepicker2 + ":00.000";
            Timestamp endTimeStamp = Timestamp.valueOf(endTime);
            if (startTimeStamp.after(endTimeStamp)) {
                return "appointments/createAppointmentError";
            }

            newApptTime.setStart(startTimeStamp);
            newApptTime.setEnd(endTimeStamp);
            newApptTime.setBabysitter(usersRepo.findOne(3L));
            newApptTime.setParent(usersRepo.findOne(1L));
            newApptTime.setSitterApproved(false);
            appointmentsRepo.save(newApptTime);
            return "redirect:/appointments";
        }

        // CREATE ERROR GET
        @GetMapping("/appointments/create?error")
        public String showCreateAppointmentsError(Model model) {
            model.addAttribute("datetime", new AvailableTime());
            return "appointments/createAppointmentError";
        }

        // CREATE ERROR POST
        @PostMapping("/appointments/create?error")
        public String reCreateAppointments(
                @RequestParam String datepicker1,
                @RequestParam String timepicker1,
                @RequestParam String datepicker2,
                @RequestParam String timepicker2) {

            Appointment newApptTime = new Appointment();

            if (makeStartTimeStamp(datepicker1, timepicker1).after(makeEndTimeStamp(datepicker2, timepicker2))) {
                return "appointments/createAppointmentError";
            }
            newApptTime.setStart(makeStartTimeStamp(datepicker1, timepicker1));
            newApptTime.setEnd(makeEndTimeStamp(datepicker2, timepicker2));
            newApptTime.setBabysitter(usersRepo.findOne(3L));
            newApptTime.setParent(usersRepo.findOne(1L));
            newApptTime.setSitterApproved(false);
            appointmentsRepo.save(newApptTime);
            return "redirect:/appointments";
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

        public Timestamp makeStartTimeStamp(String date, String time) {
            String startTime = date + " " + time + ":00.000";
            Timestamp startTimeStamp = Timestamp.valueOf(startTime);
            return startTimeStamp;
        }

        public Timestamp makeEndTimeStamp(String date, String time) {
            String endTime = date + " " + time + ":00.000";
            Timestamp endTimeStamp = Timestamp.valueOf(endTime);
            return endTimeStamp;
        }

    }






