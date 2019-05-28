//package com.codeup.sittergitter.controllers;
//
//import com.codeup.sittergitter.models.User;
//import com.codeup.sittergitter.repositories.UserRepository;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.util.NestedServletException;
//
//@Controller
//@ControllerAdvice
//public class GlobalControllerAdvice {
//
//    private final UserRepository usersRepo;
//
//    public GlobalControllerAdvice(UserRepository usersRepo) {
//        this.usersRepo = usersRepo;
//    }
//
//    @GetMapping("/**")
//    @ModelAttribute("ssnUser")
//    public Model appHandler(Model model) {
//        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User userDB = usersRepo.findOne(sessionUser.getId());
////        if (userDB.getUsername() == null) {
////            return Model asdf = new Model();
////        }
//        model.addAttribute("ssnUser", userDB);
//        return model;
//    }
//
////    @ModelAttribute("ssnUser")
////    public void populateUser(Model model) {
////        try {
////
////            model.addAttribute("ssnUser", userDB.getisBabysitter());
////        } catch (Exception e) {
////            System.out.println(e);
////        }
////
////
////
//////        if (sessionUser == null) {
//////            userDB = null;
//////        }
////
//////        User user = /* Get your user from service or security context or elsewhere */;
////    }
//}
//
//
////@Controller
////public class MyController {
////    @Autowired
////    private VisitorInfo visitorInfo;
////
//
////
////    @PostMapping("/visitor")
////    public String visitorHandler(String name) {
////        visitorInfo.setName(name);
////        visitorInfo.setFirstVisitTime(LocalDateTime.now());
////        return "redirect:/";
////    }
////}