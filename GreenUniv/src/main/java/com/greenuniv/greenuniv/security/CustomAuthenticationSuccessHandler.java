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

        // "role" 파라미터 가져오기 (예: "professor,admin")
        String roleParam = request.getParameter("role");
        if (roleParam == null || roleParam.isEmpty()) {
            response.sendRedirect("/login/login?code=100"); // role 값이 없으면 실패 처리
            return;
        }

        // 역할 분리
        String[] roles = roleParam.split(","); // "professor"와 "admin"으로 분리

        // 인증된 사용자 정보 가져오기
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        UserEntity user = userDetails.getUser();

        // 사용자의 Role(Enum)과 폼에서 전달된 Role 값 비교
        boolean isValidRole = false;
        for (String roleFromForm : roles) {
            try {
                UserEntity.Role expectedRole = UserEntity.Role.valueOf(roleFromForm.trim().toUpperCase());
                if (user.getRole() == expectedRole) {
                    isValidRole = true;
                    break; // 하나라도 일치하면 유효한 역할로 간주
                }
            } catch (IllegalArgumentException e) {
                // 폼에서 전달된 Role이 Enum에 없는 경우 무시
                continue;
            }
        }

        if (!isValidRole) {
            // Role이 일치하지 않으면 로그인 실패 페이지로 리다이렉트
            response.sendRedirect("/login/login?code=100");
            return;
        }

        // Role 값에 따라 다른 페이지로 리다이렉트
        String redirectUrl = "/";
        switch (user.getRole()) {
            case student:
                redirectUrl = "/student";
                break;
            case professor:
                redirectUrl = "/professor";
                break;
            case admin:
                redirectUrl = "/admin";
                break;
            case general:
                redirectUrl = "/general";
                break;
            default:
                break;
        }

        response.sendRedirect(redirectUrl);
    }
}