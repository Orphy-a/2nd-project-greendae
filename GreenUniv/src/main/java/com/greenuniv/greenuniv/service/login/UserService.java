package com.greenuniv.greenuniv.service.login;

import com.greenuniv.greenuniv.dto.user.UserDTO;
import com.greenuniv.greenuniv.entity.user.UserEntity;
import com.greenuniv.greenuniv.repository.login.UserRepository;
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

}
