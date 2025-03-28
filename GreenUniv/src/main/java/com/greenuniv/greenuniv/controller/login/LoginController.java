package com.greenuniv.greenuniv.controller.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    @GetMapping("/login/login")
    public String login(){return "login/login";}

    @GetMapping("/login/terms")
    public String terms(){return "login/terms";}

    @GetMapping("/login/register")
    public String register(){return "login/register";}

}

