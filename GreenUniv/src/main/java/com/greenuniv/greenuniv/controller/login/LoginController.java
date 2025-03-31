package com.greenuniv.greenuniv.controller.login;

import com.greenuniv.greenuniv.dto.terms.TermsDTO;
import com.greenuniv.greenuniv.dto.user.UserDTO;
import com.greenuniv.greenuniv.service.login.TermsService;
import com.greenuniv.greenuniv.service.login.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final TermsService termsService;
    private final UserService userService;

    @GetMapping("/login/login")
    public String login(){return "login/login";}

    @GetMapping("/login/terms")
    public String terms(Model model){

        TermsDTO term = termsService.term();
        TermsDTO privacy = termsService.privacy();

        model.addAttribute("term", term);
        model.addAttribute("privacy", privacy);

        return "/login/terms";
    }

    @GetMapping("/login/register")
    public String register(){return "login/register";}


    @PostMapping("/login/register")
    public String register(UserDTO userDTO){


        userService.register(userDTO);

        return "redirect:/login/login";
    }

}

