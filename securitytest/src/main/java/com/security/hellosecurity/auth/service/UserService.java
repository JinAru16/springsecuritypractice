package com.security.hellosecurity.auth.service;

import com.security.hellosecurity.auth.domain.entity.Users;
import com.security.hellosecurity.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Users create(String userId, String password, String email, String authority){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        passwordEncoder.encode(password);
        Users user = Users.builder()
                .userId(userId)
                .password( passwordEncoder.encode(password))
                .email(email)
                .authority(authority)
                .build();

        return userRepository.save(user);
    }

}
