package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.Appointment;
import com.codeup.sittergitter.models.AvailableTime;
import com.codeup.sittergitter.repositories.AppointmentRepository;
import com.codeup.sittergitter.repositories.AvailableTimeRepository;
import com.codeup.sittergitter.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Calendar;


@Controller
public class AvailableTimeController {

    private final AvailableTimeRepository availableTimesRepo;
    private final AppointmentRepository appointmentsRepo;
    private final UserRepository usersRepo;

    public AvailableTimeController(AvailableTimeRepository availableTimesRepo, AppointmentRepository appointmentsRepo
            , UserRepository usersRepo) {
        this.availableTimesRepo = availableTimesRepo;
        this.appointmentsRepo = appointmentsRepo;
        this.usersRepo = usersRepo;
    }

    // CREATE AVAILABLE TIMES GET
    @GetMapping("/available-times/create")
    public String babysitterChoices1(Model model) {
        model.addAttribute("datetime", new AvailableTime());
        return "availableTimes/createAvailableTimes";
    }

    // CREATE AVAILABLE TIMES POST
    @PostMapping("/available-times/create")
    public String createAvailTime(
            @RequestParam String datepicker1,
            @RequestParam String timepicker1,
            @RequestParam String datepicker2,
            @RequestParam String timepicker2) {

        AvailableTime newAvailTime = new AvailableTime();

        String startTime = datepicker1 + " " + timepicker1 + ":00.000";
        Timestamp startTimeStamp = Timestamp.valueOf(startTime);
        String endTime = datepicker2 + " " + timepicker2 + ":00.000";
        Timestamp endTimeStamp = Timestamp.valueOf(endTime);
        if (startTimeStamp.after(endTimeStamp)) {
            return "availableTimes/createError";
        }
        newAvailTime.setStart(startTimeStamp);
        newAvailTime.setEnd(endTimeStamp);
        newAvailTime.setBabysitter(usersRepo.findOne(3L));
        availableTimesRepo.save(newAvailTime);
        return "redirect:/available-times";
    }

    // READ AVAILABLE TIMES GET
    @GetMapping("/available-times")
    public String displayAllAvailTimes(Model model) {
        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        Timestamp currentTimeStamp = new Timestamp(now.getTime());
        System.out.println(currentTimeStamp);
        model.addAttribute("current_time", currentTimeStamp);
        model.addAttribute("available_times", availableTimesRepo.findByOrderByStartAsc());
//        model.addAttribute("available_times", availableTimesRepo.findAll());
        return "availableTimes/showAvailableTimes";
    }

    // UPDATE AVAILABLE TIMES POST
    @PostMapping("/available-times/{id}/edit")
    public String editAvailableTime(@ModelAttribute AvailableTime availableTimeToBeEdited){
        availableTimeToBeEdited.setBabysitter(usersRepo.findOne(1L));
        availableTimesRepo.save(availableTimeToBeEdited);
        return "redirect:/available-times/";
    }

    // DELETE AVAILABLE TIMES
    @GetMapping("/available-times/{id}/delete")
    public String deleteAvailableTime(@PathVariable Long id){
        availableTimesRepo.deleteById(id);
        return "redirect:/available-times";
    }

    // CREATE ERROR GET
    @GetMapping("/available-times/create?error")
    public String babysitterChoices2(Model model) {
        model.addAttribute("datetime", new AvailableTime());
        return "availableTimes/createError";
    }

    // CREATE ERROR POST
    @PostMapping("/available-times/create?error")
    public String recreateAvailTime(
            @RequestParam String datepicker1,
            @RequestParam String timepicker1,
            @RequestParam String datepicker2,
            @RequestParam String timepicker2) {

        AvailableTime newAvailTime = new AvailableTime();

        String startTime = datepicker1 + " " + timepicker1 + ":00.000";
        Timestamp startTimeStamp = Timestamp.valueOf(startTime);
        String endTime = datepicker2 + " " + timepicker2 + ":00.000";
        Timestamp endTimeStamp = Timestamp.valueOf(endTime);
        if (startTimeStamp.after(endTimeStamp)) {
            return "availableTimes/createError";
        }
        newAvailTime.setStart(startTimeStamp);
        newAvailTime.setEnd(endTimeStamp);
        newAvailTime.setBabysitter(usersRepo.findOne(3L));
        availableTimesRepo.save(newAvailTime);
        return "redirect:/available-times";
    }

}
