package com.greenuniv.greenuniv.security;

import com.greenuniv.greenuniv.entity.user.UserEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        // 1. 로그인 폼에서 전달된 Role 값을 가져옴
        String role = request.getParameter("role");

        // 2. 인증된 사용자 정보를 가져옴
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        UserEntity user = userDetails.getUser();

        String redirectUrl = "/"; // 기본 리다이렉트 URL

        // 3. Role 검증
        if (!user.getRole().name().equalsIgnoreCase(role)) {
            // Role이 일치하지 않으면, 로그인 실패 페이지로 리다이렉트
            response.sendRedirect("/login/login?code=100");
            return;
        }

        // 4. Role 값에 따라 다른 페이지로 리다이렉트
        if ("student".equalsIgnoreCase(role)) {
            redirectUrl = "/student";
        } else if ("professor".equalsIgnoreCase(role)) {
            redirectUrl = "/professor";
        } else if ("general".equalsIgnoreCase(role)) {
            redirectUrl = "/general";
        }

        response.sendRedirect(redirectUrl);
    }
}