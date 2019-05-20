package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.Appointment;
import com.codeup.sittergitter.models.AvailableTime;
import com.codeup.sittergitter.repositories.AppointmentRepository;
import com.codeup.sittergitter.repositories.AvailableTimeRepository;
import com.codeup.sittergitter.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Controller
public class TestDwightController {

    private final AvailableTimeRepository availableTimesRepo;
    private final AppointmentRepository appointmentsRepo;
    private final UserRepository usersRepo;
    private List<AvailableTime> availBabysitters;

    public TestDwightController(AvailableTimeRepository availableTimesRepo, AppointmentRepository appointmentsRepo, UserRepository usersRepo) {
        this.availableTimesRepo = availableTimesRepo;
        this.appointmentsRepo = appointmentsRepo;
        this.usersRepo = usersRepo;
    }

    @GetMapping("/available-times")
    public String displayAllAvailTimes(Model model) {
        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        java.sql.Timestamp currentTimeStamp = new java.sql.Timestamp(now.getTime());
        System.out.println(currentTimeStamp);
        model.addAttribute("current_time", currentTimeStamp);
        model.addAttribute("available_times", availableTimesRepo.findByOrderByStartAsc());
//        model.addAttribute("available_times", availableTimesRepo.findAll());
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
        return "babysitter-choose-times-error";
    }

    @PostMapping("/babysitter-choose-times-error")
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
        return "babysitter-choose-times-null-values";
    }

    @PostMapping("/babysitter-choose-times-null-values")
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

    @GetMapping("/enter-appointment-time")
    public String parentChoices1(Model model) {
        model.addAttribute("datetime", new Appointment());
        return "dwight-parent-choose-times";
    }

    @PostMapping("/dwight-parent-choose-times")
    public String enterApptTime(@RequestParam String datepicker1, @RequestParam String timepicker1, @RequestParam String datepicker2, @RequestParam String timepicker2, Model model) {
        Appointment newApptTime = new Appointment();
        if (datepicker1.isEmpty() || datepicker2.isEmpty() || timepicker1.isEmpty() || timepicker2.isEmpty()) {
            return "redirect:/parent-choices-null-values";
        }
        String startTime = datepicker1 + " " + timepicker1 + ":00.000";
        Timestamp startTimeStamp = Timestamp.valueOf(startTime);
        String endTime = datepicker2 + " " + timepicker2 + ":00.000";
        Timestamp endTimeStamp = Timestamp.valueOf(endTime);
        if (startTimeStamp.after(endTimeStamp)) {
            return "redirect:/parent-choices-error";
        }
        availBabysitters = checkTimeAvailability(startTimeStamp, endTimeStamp);
//        newApptTime.setStart(startTimeStamp);
//        newApptTime.setEnd(endTimeStamp);
//        newApptTime.setBabysitter(usersRepo.findOne(3L));
//        newApptTime.setParent(usersRepo.findOne(1L));
//        newApptTime.setSitterApproved(false);
//        appointmentsRepo.save(newApptTime);
        return "redirect:/available-babysitters";
    }

    @GetMapping("/parent-choices-error")
    public String parentChoices2(Model model) {
        model.addAttribute("datetime", new AvailableTime());
        return "parent-choose-times-error";
    }

    @PostMapping("/parent-choose-times-error")
    public String recreateApptTime(@RequestParam String datepicker1, @RequestParam String timepicker1, @RequestParam String datepicker2, @RequestParam String timepicker2) {
        Appointment newApptTime = new Appointment();
        if (datepicker1.isEmpty() || datepicker2.isEmpty() || timepicker1.isEmpty() || timepicker2.isEmpty()) {
            return "redirect:/parent-choices-null-values";
        }
        if (makeStartTimeStamp(datepicker1, timepicker1).after(makeEndTimeStamp(datepicker2, timepicker2))) {
            return "redirect:/parent-choices-error";
        }
        newApptTime.setStart(makeStartTimeStamp(datepicker1, timepicker1));
        newApptTime.setEnd(makeEndTimeStamp(datepicker2, timepicker2));
        newApptTime.setBabysitter(usersRepo.findOne(3L));
        newApptTime.setParent(usersRepo.findOne(1L));
        newApptTime.setSitterApproved(false);
        appointmentsRepo.save(newApptTime);
        return "redirect:/available-times";
    }

    @GetMapping("/parent-choices-null-values")
    public String parentChoices3(Model model) {
        model.addAttribute("datetime", new AvailableTime());
        return "parent-choose-times-null-values";
    }

    @PostMapping("/parent-choose-times-null-values")
    public String redoApptTime(@RequestParam String datepicker1, @RequestParam String timepicker1, @RequestParam String datepicker2, @RequestParam String timepicker2) {
        Appointment newApptTime = new Appointment();
        if (datepicker1.isEmpty() || datepicker2.isEmpty() || timepicker1.isEmpty() || timepicker2.isEmpty()) {
            return "redirect:/parent-choices-null-values";
        }
        if (makeStartTimeStamp(datepicker1, timepicker1).after(makeEndTimeStamp(datepicker2, timepicker2))) {
            return "redirect:/parent-choices-error";
        }
        newApptTime.setStart(makeStartTimeStamp(datepicker1, timepicker1));
        newApptTime.setEnd(makeEndTimeStamp(datepicker2, timepicker2));
        newApptTime.setBabysitter(usersRepo.findOne(3L));
        newApptTime.setParent(usersRepo.findOne(1L));
        newApptTime.setSitterApproved(false);
        appointmentsRepo.save(newApptTime);
        return "redirect:/available-times";
    }

    @GetMapping("/available-babysitters")
    public String displayAvailBabysitters(Model model) {
        model.addAttribute("babysitters", availBabysitters);
        return "dwight-available-babysitters";
    }

    @PostMapping("/dwight-available-babysitters")
    public String chooseBabysitter(@RequestParam long id) {
        //        newApptTime.setStart(startTimeStamp);
//        newApptTime.setEnd(endTimeStamp);
//        newApptTime.setBabysitter(usersRepo.findOne(3L));
//        newApptTime.setParent(usersRepo.findOne(1L));
//        newApptTime.setSitterApproved(false);
//        appointmentsRepo.save(newApptTime);
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

    public List<AvailableTime> checkTimeAvailability(Timestamp apptFrom, Timestamp apptTo) {
        List<AvailableTime> babysitters = new ArrayList<>();
        List<AvailableTime> availableTimes = availableTimesRepo.findAll();
        for (AvailableTime time : availableTimes) {
            Timestamp startTime = time.getStart();
            Timestamp endTime = time.getEnd();

            if (((apptFrom.after(startTime) || apptFrom.equals(startTime)) &&
                    (apptFrom.before(endTime) || apptFrom.equals(endTime))) &&
                    ((apptTo.after(startTime) || (apptTo.equals(startTime))) &&
                    ((apptTo.before(endTime)) || apptTo.equals(endTime)))) {
                babysitters.add(time);
            }

        }
//        if ((fromTime.isAfter(startTime)))
        return babysitters;
    }

//    @GetMapping("/available-times/{id}/display")
//    public String displayAvailTimesById(@PathVariable long id, Model model) {
//        model.addAttribute("available-times", availableTimesRepository.findAvailableTimesByBabysitter_Id(id));
//        return "dwight-available-times";
//    }

    public static void main(String[] args) {
//        List<AvailableTime> availableTimes = availableTimesRepo.findAll();
//        for (AvailableTime time : availableTimes) {
//            System.out.println(time);
//        }


    }


}
