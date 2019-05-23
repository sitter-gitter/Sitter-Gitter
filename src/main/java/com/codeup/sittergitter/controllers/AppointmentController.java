package com.codeup.sittergitter.controllers;

import com.codeup.sittergitter.models.Appointment;
import com.codeup.sittergitter.models.AvailableTime;
import com.codeup.sittergitter.models.User;
import com.codeup.sittergitter.repositories.*;
import com.codeup.sittergitter.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
public class AppointmentController {

    private final ReviewRepository reviewsRepo;
    private final UserRepository usersRepo;
    private final AppointmentRepository appointmentsRepo;
    private final AvailableTimeRepository availableTimesRepo;
    private final ChildRepository childrenRepo;
    private final SpecificationRepository specificationsRepo;
    private EmailService emailService;
    private List<AvailableTime> availApptTimes;
    private Long sitterId;
    private Timestamp apptStartTime;
    private Timestamp apptEndTime;

    public AppointmentController(ReviewRepository reviewsRepo,
                                 UserRepository usersRepo,
                                 AppointmentRepository appointmentsRepo,
                                 AvailableTimeRepository availableTimesRepo,
                                 ChildRepository childrenRepo,
                                 SpecificationRepository specificationsRepo,
                                 EmailService emailService) {
        this.reviewsRepo = reviewsRepo;
        this.usersRepo = usersRepo;
        this.appointmentsRepo = appointmentsRepo;
        this.availableTimesRepo = availableTimesRepo;
        this.childrenRepo = childrenRepo;
        this.specificationsRepo = specificationsRepo;
        this.emailService = emailService;
    }

        // CREATE APPOINTMENT TIME GET
        @GetMapping("/appointments/create")
        public String parentChoices1(Model model) {
            model.addAttribute("datetime", new Appointment());
            return "appointments/createAppointment";
        }

        // CREATE APPOINTMENT TIME POST
        @PostMapping("/appointments/create")
        public String enterApptTime(
                @RequestParam String datepicker1,
                @RequestParam String timepicker1,
                @RequestParam String datepicker2,
                @RequestParam String timepicker2,
                @ModelAttribute Appointment newApptTime) {

            String startTime = datepicker1 + " " + timepicker1 + ":00.000";
            apptStartTime = Timestamp.valueOf(startTime);
            String endTime = datepicker2 + " " + timepicker2 + ":00.000";
            apptEndTime = Timestamp.valueOf(endTime);
            if (apptStartTime.after(apptEndTime)) {
                return "appointments/createAppointmentError";
            }
            availApptTimes = checkTimeAvailability(apptStartTime, apptEndTime);
            return "redirect:/appointments/available-babysitters";
        }

        // CREATE ERROR GET asdf
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
                @RequestParam String timepicker2,
                @ModelAttribute Appointment newApptTime) {

            if (makeStartTimeStamp(datepicker1, timepicker1).after(makeEndTimeStamp(datepicker2, timepicker2))) {
                return "appointments/createAppointmentError";
            }
            availApptTimes = checkTimeAvailability(apptStartTime, apptEndTime);
            return "redirect:/appointments/available-babysitters";
        }

        // READ ALL APPOINTMENTS
    @GetMapping("/appointments")
    public String showAppointments(Model model) {
        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        Timestamp currentTimeStamp = new Timestamp(now.getTime());
        System.out.println(currentTimeStamp);
        model.addAttribute("current_time", currentTimeStamp);
        model.addAttribute("appointments", appointmentsRepo.findByOrderByStartAsc());
//        model.addAttribute("appointments", appointmentsRepo.findAll());
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

    public List<AvailableTime> checkTimeAvailability(Timestamp apptFrom, Timestamp apptTo) {
        List<AvailableTime> babysitterTimes = new ArrayList<>();
        List<AvailableTime> availableTimes = availableTimesRepo.findAll();
        for (AvailableTime time : availableTimes) {
            Timestamp startTime = time.getStart();
            Timestamp endTime = time.getEnd();

            if (((apptFrom.after(startTime) || apptFrom.equals(startTime)) &&
                    (apptFrom.before(endTime) || apptFrom.equals(endTime))) &&
                    ((apptTo.after(startTime) || (apptTo.equals(startTime))) &&
                            ((apptTo.before(endTime)) || apptTo.equals(endTime)))) {
                babysitterTimes.add(time);
            }

        }

        return babysitterTimes;
    }

    @GetMapping("/appointments/available-babysitters")
    public String displayAvailBabysitters(Model model) {
        model.addAttribute("availAppts", availApptTimes);
        return "appointments/availableBabysitters";
    }


    @PostMapping("/appointments/availableBabysitters")
    public String chooseBabysitter(@ModelAttribute Appointment newApptTime, @RequestParam long sitterid) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDB = usersRepo.findOne(sessionUser.getId());
        sitterId = sitterid;
        newApptTime.setStart(apptStartTime);
        newApptTime.setEnd(apptEndTime);
        newApptTime.setBabysitter(usersRepo.findOne(sitterId));
        newApptTime.setParent(userDB);
        newApptTime.setSitterApproved(true);
        Appointment savedAppt = appointmentsRepo.save(newApptTime);
        emailService.sendAppointmentNotification(savedAppt, "Babysitting Appointment", "An appointment has been made for the following time slot: " + savedAppt.getStart() + " until " + savedAppt.getEnd());
        return "redirect:/appointments";
    }

    // DELETE AVAILABLE TIMES
    @GetMapping("/appointments/{id}/delete")
    public String deleteAppointment(@PathVariable Long id){
        appointmentsRepo.deleteById(id);
        return "redirect:/appointments";
    }

}






