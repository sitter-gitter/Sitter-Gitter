package com.codeup.sittergitter.controllers.oldControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestMindyController {

  @GetMapping("/test/mindy")
  public String splashTest() { return "mjt-home"; }

  @GetMapping("/test/mindy/login")
  public String loginTest() { return "mjt-login"; }
//
//  @GetMapping("/test/mindy/register")
//  public String registerTest() { return "mjt-register"; }
//
//  @GetMapping("/test/mindy/register-parent")
//  public String registerParent() { return "mjt-register-parent"; }

//  @GetMapping("/test/mindy/register-babysitter")
//  public String registerBabysitter() { return "mjt-register-babysitter"; }
}
