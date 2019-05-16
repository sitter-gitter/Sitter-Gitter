package com.codeup.sittergitter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

  @GetMapping("/test")
  public String SplashTest() {
    return "sghome";
  }

  @GetMapping("/test/login")
  public String LoginTest() { return "login"; }

  @GetMapping("/test/register")
  public String RegisterTest() { return "register"; }

  @GetMapping("/test/parent")
  public String RegisterParent() { return "parent"; }

  @GetMapping("/test/babysitter")
  public String RegisterBabysitter() { return "babysitter"; }
}
