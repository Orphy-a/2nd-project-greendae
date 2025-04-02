package com.greenuniv.greenuniv.security;

import com.greenuniv.greenuniv.entity.user.UserEntity;
import com.greenuniv.greenuniv.repository.login.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        log.info("Id : {}", id);

        // 1. RequestContextHolder를 사용하여 요청 정보를 가져옴
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 2. 폼에서 전달된 Role 값을 가져옴
        String selectedRole = request.getParameter("role");

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));

        // 3, Role 검증
        if(selectedRole == null || !user.getRole().name().equalsIgnoreCase(selectedRole)) {
            throw new BadCredentialsException("Role mismatch");
        }

        MyUserDetails myUserDetails = MyUserDetails.builder()
                .user(user)
                .build();

        return myUserDetails;
    }
}