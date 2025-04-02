package com.greenuniv.greenuniv.controller.login;

import com.greenuniv.greenuniv.dto.terms.TermsDTO;
import com.greenuniv.greenuniv.dto.user.UserDTO;
import com.greenuniv.greenuniv.service.login.TermsService;
import com.greenuniv.greenuniv.service.login.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final TermsService termsService;
    private final UserService userService;


    @GetMapping("/login/login")
    public String login(@RequestParam(value = "code", required = false) String code, Model model) {
        if (code != null && code.equals("100")) {
            model.addAttribute("loginError", true);
        }
        return "/login/login";
    }

    @PostMapping("/login/login")
    public String login(@ModelAttribute UserDTO userDTO, HttpServletRequest request, Model model) {

        String role = request.getParameter("role");

        String[] roles = role.split(",");


        // 필요한 로직 처리 (예: 인증, 권한 확인 등)
        model.addAttribute("userDTO", userDTO);

        return "redirect:/"; // 메인 페이지로 리다이렉트
    }

    @GetMapping("/login/terms")
    public String terms(Model model){

        TermsDTO term = termsService.term();
        TermsDTO privacy = termsService.privacy();

        model.addAttribute("term", term);
        model.addAttribute("privacy", privacy);

        return "/login/terms";
    }

    @GetMapping("/login/register/id/{value}")
    public ResponseEntity<Map<String, Object>> checkUserId(@PathVariable("value") String value) {

        log.info("Checking user id: " + value);
        Map<String, Object> response = new HashMap<>();

        try {
            // 아이디 중복 여부 확인
            boolean isDuplicate = userService.isUserIdDuplicate(value);

            // 결과 반환
            response.put("count", isDuplicate ? 1 : 0); // 중복이면 count=1, 아니면 count=0
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // 예외 처리
            response.put("error", "서버 오류가 발생했습니다.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/login/register/email/{value}")
    public ResponseEntity<Map<String, Object>> checkEmail(@PathVariable("value") String value) {

        log.info("Checking email: " + value);
        Map<String, Object> response = new HashMap<>();

        try {
            // 이메일 중복 여부 확인
            boolean isDuplicate = userService.isUserEmailDuplicate(value);

            // 결과 반환
            response.put("count", isDuplicate ? 1 : 0); // 중복이면 count=1, 아니면 count=0
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // 예외 처리
            response.put("error", "서버 오류가 발생했습니다.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/login/register/contact/{value}")
    public ResponseEntity<Map<String, Object>> checkContact(@PathVariable("value") String value) {
        log.info("Checking contact hp: " + value);
        Map<String, Object> response = new HashMap<>();

        try{
            // 휴대폰 번호 중복 여부 확인
            boolean isDuplicate = userService.isUserContactDuplicate(value);

            // 결과 반환
            response.put("count", isDuplicate ? 1 : 0); // 중복이면 count=1, 아니면 count=0
            return ResponseEntity.ok(response);


        }catch (Exception e){
            response.put("error", "서버 오류가 발생했습니다.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }


    @GetMapping("/login/register")
    public String register(){return "/login/register";}


    @PostMapping("/login/register")
    public String register(UserDTO userDTO){

        userService.register(userDTO);

        return "redirect:/login/login";
    }

}