package com.greenuniv.greenuniv.controller.login;

import com.greenuniv.greenuniv.dto.terms.TermsDTO;
import com.greenuniv.greenuniv.service.login.TermsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final TermsService termsService;


    @GetMapping("/login/login")
    public String login(){return "login/login";}

    @GetMapping("/login/terms")
    public String terms(Model model){

        TermsDTO term = termsService.term();
        TermsDTO privacy = termsService.privacy();

        model.addAttribute("term", term);
        model.addAttribute("privacy", privacy);

        return "login/terms";
    }

    @GetMapping("/login/register")
    public String register(){return "login/register";}

}

