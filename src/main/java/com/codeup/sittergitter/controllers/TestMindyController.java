package com.codeup.sittergitter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestMindyController {

  @GetMapping("/test/mindy")
  public String SplashTest() { return "sghome"; }

  @GetMapping("/test/mindy/login")
  public String LoginTest() { return "login"; }

  @GetMapping("/test/mindy/register")
  public String RegisterTest() { return "register"; }

  @GetMapping("/test/mindy/register-parent")
  public String RegisterParent() { return "register-parent"; }

  @GetMapping("/test/mindy/register-babysitter")
  public String RegisterBabysitter() { return "register-babysitter"; }
}
