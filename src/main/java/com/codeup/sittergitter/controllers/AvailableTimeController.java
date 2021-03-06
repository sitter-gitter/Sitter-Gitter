package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.Appointment;
import com.codeup.sittergitter.models.AvailableTime;
import com.codeup.sittergitter.models.User;
import com.codeup.sittergitter.repositories.AppointmentRepository;
import com.codeup.sittergitter.repositories.AvailableTimeRepository;
import com.codeup.sittergitter.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Calendar;


@Controller
public class AvailableTimeController {

    private final AvailableTimeRepository availableTimesRepo;
    private final UserRepository usersRepo;

    public AvailableTimeController(AvailableTimeRepository availableTimesRepo, UserRepository usersRepo) {
        this.availableTimesRepo = availableTimesRepo;
        this.usersRepo = usersRepo;
    }

    // CREATE AVAILABLE TIMES GET
    @GetMapping("/available-times/create")
    public String babysitterChoices1(Model model) {
        model.addAttribute("datetime", new AvailableTime());
        return "availableTimes/createAvailableTimes";
    }

    // CREATE AVAILABLE TIMES POST (SEE ALSO recreateAvailTime METHOD BELOW)
    @PostMapping("/available-times/create")
    public String createAvailTime(
            @RequestParam String datepicker1,
            @RequestParam String timepicker1,
            @RequestParam String datepicker2,
            @RequestParam String timepicker2,
            @ModelAttribute AvailableTime newAvailTime) {

        timepicker1 = timeConverter(timepicker1);
        timepicker2 = timeConverter(timepicker2);

        System.out.println(timepicker1);
        System.out.println(timepicker2);

        String startTime = datepicker1 + " " + timepicker1 + ":00.000";
        Timestamp startTimeStamp = Timestamp.valueOf(startTime);
        String endTime = datepicker2 + " " + timepicker2 + ":00.000";
        Timestamp endTimeStamp = Timestamp.valueOf(endTime);
        if (startTimeStamp.after(endTimeStamp)) {
            return "availableTimes/createError";
        }
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDB = usersRepo.findOne(sessionUser.getId());
        newAvailTime.setStart(startTimeStamp);
        newAvailTime.setEnd(endTimeStamp);
        newAvailTime.setBabysitter(userDB);
        newAvailTime.setIsTaken(false);
        availableTimesRepo.save(newAvailTime);
        return "redirect:/my-acct";
    }

    public String timeConverter(String time) {
        System.out.print(time.charAt(0));
        System.out.print(time.charAt(1));
        System.out.print(time.charAt(2));
        System.out.print(time.charAt(3));
        System.out.print(time.charAt(4));
        System.out.print(time.charAt(5));
        System.out.println(time.charAt(6));
        if (time.charAt(6) == 'A') {
            if(time.charAt(0) == '1' && time.charAt(1) == '2') {
                return "00" + time.substring(2,5);
            }
            return time.substring(0,5);
        } else if (time.charAt(6) == 'P') {
            int pmHour = Integer.parseInt(time.substring(0,2));
            if (pmHour < 12) {
                pmHour += 12;
            }
            String newTime = Integer.toString(pmHour);
           return newTime.concat(time.substring(2,5));
        }
        return "0";
    }

    // READ AVAILABLE TIMES GET
    @GetMapping("/available-times")
    public String displayAllAvailTimes(Model model) {
        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        Timestamp currentTimeStamp = new Timestamp(now.getTime());
        System.out.println(currentTimeStamp);
        model.addAttribute("current_time", currentTimeStamp);
//        model.addAttribute("available_times", availableTimesRepo.findByOrderByStartAsc());
        model.addAttribute("available_times", availableTimesRepo.findAvailableTimesByIsTakenFalseOrderByStartAsc());
        return "availableTimes/showAvailableTimes";
    }
    

//    //// TURNED EDIT FUNCTIONALITY OFF //////////
//    @GetMapping("/available-times/{id}/edit")
//    public String editForm(@PathVariable long id, Model model) {
//        AvailableTime availableTimes = availableTimesRepo.findOne(id);
//        model.addAttribute("available_times", availableTimes);
//        return "availableTimes/editAvailableTimes";
//    }
//
//    // UPDATE AVAILABLE TIMES POST
//    @PostMapping("/available-times/{id}/edit")
//    public String editAvailableTime(@ModelAttribute AvailableTime availableTimeToBeEdited){
//        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User userDB = usersRepo.findOne(sessionUser.getId());
//        availableTimeToBeEdited.setBabysitter(userDB);
//        availableTimesRepo.save(availableTimeToBeEdited);
//        return "redirect:/available-times/";
//    }
//    /////////////////////////////////////////////

    // DELETE AVAILABLE TIMES
    @GetMapping("/available-times/{id}/delete")
    public String deleteAvailableTime(@PathVariable Long id){
        availableTimesRepo.deleteById(id);
        return "redirect:/my-acct";
    }

    // CREATE ERROR GET
    @GetMapping("/available-times/create?error")
    public String babysitterChoices2(Model model) {
        model.addAttribute("datetime", new AvailableTime());
        return "availableTimes/createError";
    }

    // CREATE AVAILABLE TIME ERROR (SECOND CHANCE TO CREATE AVAILABLE TIME IF AN ERROR WAS MADE IN ENTERING DATETIME)
    @PostMapping("/available-times/create?error")
    public String recreateAvailTime(
            @RequestParam String datepicker1,
            @RequestParam String timepicker1,
            @RequestParam String datepicker2,
            @RequestParam String timepicker2,
            @ModelAttribute AvailableTime newAvailTime) {

        String startTime = datepicker1 + " " + timepicker1 + ":00.000";
        Timestamp startTimeStamp = Timestamp.valueOf(startTime);
        String endTime = datepicker2 + " " + timepicker2 + ":00.000";
        Timestamp endTimeStamp = Timestamp.valueOf(endTime);
        if (startTimeStamp.after(endTimeStamp)) {
            return "availableTimes/createError";
        }
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDB = usersRepo.findOne(sessionUser.getId());
        newAvailTime.setStart(startTimeStamp);
        newAvailTime.setEnd(endTimeStamp);
        newAvailTime.setBabysitter(userDB);
        newAvailTime.setIsTaken(false);
        availableTimesRepo.save(newAvailTime);
        return "redirect:/my-acct";
    }

}
