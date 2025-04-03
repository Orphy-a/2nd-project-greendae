package com.greenuniv.greenuniv.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {

    http
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/department/**").hasAnyRole("admin", "professor")
            .requestMatchers("/humanResourcesManagement/**").hasAnyRole("admin", "professor")
            .requestMatchers("/management/**").hasAnyRole("admin", "professor")
            .requestMatchers("/article/modify/**").hasAnyRole("admin", "student", "professor")
            .requestMatchers("/article/publish/**").hasAnyRole("admin", "student", "professor")
            .requestMatchers("/article/delete/**").hasAnyRole("admin", "student", "professor")
            .requestMatchers("/article/view/**")
            .authenticated()
            .anyRequest().permitAll()
        )
        .formLogin(login -> login
            .loginPage("/login/login") // 로그인 페이지(GET 요청)
            .loginProcessingUrl("/login/login") // 로그인 처리(POST 요청)
            .defaultSuccessUrl("/") // 성공 시 리다이렉트 URL
            .failureUrl("/login/login?code=100") // 실패 시 리다이렉트 URL
            .usernameParameter("id") // 사용자 ID 파라미터 이름 설정
            .passwordParameter("password") // 비밀번호 파라미터 이름 설정
            .permitAll()
        )
        .logout(logout -> logout
            .logoutUrl("/login/logout") // 로그아웃 URL 설정
            .invalidateHttpSession(true) // 로그아웃 시 세션 무효화
            .logoutSuccessUrl("/") // 로그아웃 성공 후 리다이렉트 URL
            .deleteCookies("JSESSIONID") // 쿠키 삭제
        )
        .sessionManagement(session -> session
            .sessionFixation().changeSessionId() // 세션 고정 공격 방지 설정
            .maximumSessions(1) // 최대 세션 개수 설정 (동시 로그인 제한)
            .maxSessionsPreventsLogin(true) // 초과 시 새로운 로그인 차단 설정
        )
        .csrf(AbstractHttpConfigurer::disable);


        /*
            인가 설정
             - MyUserDetails 권한 목록 생성하는 메서드(getAuthorities)에서 접두어로 ROLE_ 입력해야 hasRole, hasAnyRole 권한 처리됨
             - Spring Security는 기본적으로 인가 페이지 대해 login 페이지로 redirect 수행
        */

    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    // Security 암호화 인코더 설정
    //return new BCryptPasswordEncoder();
    return new MessageDigestPasswordEncoder("sha-256");
  }


}