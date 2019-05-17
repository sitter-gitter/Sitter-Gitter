package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.AvailableTime;
import com.codeup.sittergitter.repositories.AvailableTimeRepository;
import com.codeup.sittergitter.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;

@Controller
public class TestDwightController {

    private final AvailableTimeRepository availableTimesRepo;
    private final UserRepository usersRepo;

    public TestDwightController(AvailableTimeRepository availableTimesRepo, UserRepository usersRepo) {
        this.availableTimesRepo = availableTimesRepo;
        this.usersRepo = usersRepo;
    }

    @GetMapping("/available-times")
    public String displayAllAvailTimes(Model model) {
        model.addAttribute("available_times", availableTimesRepo.findAll());
        return "dwight-available-times";
    }

    @GetMapping("/make-babysitter-choices")
    public String babysitterChoices1(Model model) {
        model.addAttribute("datetime", new AvailableTime());
        return "dwight-babysitter-choose-times";
    }

    @PostMapping("/dwight-babysitter-choose-times")
    public String createAvailTime(@RequestParam String datepicker1, @RequestParam String timepicker1, @RequestParam String datepicker2, @RequestParam String timepicker2) {
        AvailableTime newAvailTime = new AvailableTime();
        if (datepicker1.isEmpty() || datepicker2.isEmpty() || timepicker1.isEmpty() || timepicker2.isEmpty()) {
            return "redirect:/babysitter-choices-null-values";
        }
        String startTime = datepicker1 + " " + timepicker1 + ":00.000";
        Timestamp startTimeStamp = Timestamp.valueOf(startTime);
        String endTime = datepicker2 + " " + timepicker2 + ":00.000";
        Timestamp endTimeStamp = Timestamp.valueOf(endTime);
        if (startTimeStamp.after(endTimeStamp)) {
            return "redirect:/babysitter-choices-error";
        }
        newAvailTime.setStart(startTimeStamp);
        newAvailTime.setEnd(endTimeStamp);
        newAvailTime.setBabysitter(usersRepo.findOne(3L));
        availableTimesRepo.save(newAvailTime);
        return "redirect:/available-times";
    }

    @GetMapping("/babysitter-choices-error")
    public String babysitterChoices2(Model model) {
        model.addAttribute("datetime", new AvailableTime());
        return "dwight-choose-times-error";
    }

    @PostMapping("/dwight-choose-times-error")
    public String recreateAvailTime(@RequestParam String datepicker1, @RequestParam String timepicker1, @RequestParam String datepicker2, @RequestParam String timepicker2) {
        AvailableTime newAvailTime = new AvailableTime();
        if (datepicker1.isEmpty() || datepicker2.isEmpty() || timepicker1.isEmpty() || timepicker2.isEmpty()) {
            return "redirect:/babysitter-choices-null-values";
        }
        if (makeStartTimeStamp(datepicker1, timepicker1).after(makeEndTimeStamp(datepicker2, timepicker2))) {
            return "redirect:/babysitter-choices-error";
        }
        newAvailTime.setStart(makeStartTimeStamp(datepicker1, timepicker1));
        newAvailTime.setEnd(makeEndTimeStamp(datepicker2, timepicker2));
        newAvailTime.setBabysitter(usersRepo.findOne(3L));
        availableTimesRepo.save(newAvailTime);
        return "redirect:/available-times";
    }

    @GetMapping("/babysitter-choices-null-values")
    public String babysitterChoices3(Model model) {
        model.addAttribute("datetime", new AvailableTime());
        return "dwight-choose-times-null-values";
    }

    @PostMapping("/dwight-choose-times-null-values")
    public String redoAvailTime(@RequestParam String datepicker1, @RequestParam String timepicker1, @RequestParam String datepicker2, @RequestParam String timepicker2) {
        AvailableTime newAvailTime = new AvailableTime();
        if (datepicker1.isEmpty() || datepicker2.isEmpty() || timepicker1.isEmpty() || timepicker2.isEmpty()) {
            return "redirect:/babysitter-choices-null-values";
        }
        if (makeStartTimeStamp(datepicker1, timepicker1).after(makeEndTimeStamp(datepicker2, timepicker2))) {
            return "redirect:/babysitter-choices-error";
        }
        newAvailTime.setStart(makeStartTimeStamp(datepicker1, timepicker1));
        newAvailTime.setEnd(makeEndTimeStamp(datepicker2, timepicker2));
        newAvailTime.setBabysitter(usersRepo.findOne(3L));
        availableTimesRepo.save(newAvailTime);
        return "redirect:/available-times";

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


//    @GetMapping("/available-times/{id}/display")
//    public String displayAvailTimesById(@PathVariable long id, Model model) {
//        model.addAttribute("available-times", availableTimesRepository.findAvailableTimesByBabysitter_Id(id));
//        return "dwight-available-times";
//    }


}
