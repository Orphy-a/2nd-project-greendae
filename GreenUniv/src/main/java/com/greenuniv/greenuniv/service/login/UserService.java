package com.greenuniv.greenuniv.service.login;

import com.greenuniv.greenuniv.dto.user.UserDTO;
import com.greenuniv.greenuniv.entity.user.UserEntity;
import com.greenuniv.greenuniv.repository.login.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public void register(UserDTO userDTO) {


        // 비밀번호 암호화
        String encodedPass = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPass);


        // 엔티티 변환
        UserEntity user = modelMapper.map(userDTO, UserEntity.class);

        userRepository.save(user);

    }

    // 아이디 중복 여부 확인 메서드
    public boolean isUserIdDuplicate(String id) {
        return userRepository.existsById(id); // DB에 존재하는지 확인
    }

    // 이메일 중복 여부 확인 메서드
    public boolean isUserEmailDuplicate(String email) {
        return userRepository.existsByEmail(email); // DB에 존재하는지 확인
    }

    // 휴대폰 중복 여부 확인 메서드
    public boolean isUserContactDuplicate(String contact) {
        return userRepository.existsByContact(contact);
    }

}