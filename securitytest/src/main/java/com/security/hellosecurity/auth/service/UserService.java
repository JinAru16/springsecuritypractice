package com.security.hellosecurity.auth.service;

import com.security.hellosecurity.auth.domain.entity.Users;
import com.security.hellosecurity.auth.domain.request.UserCreate;
import com.security.hellosecurity.auth.repository.UserRepository;
import com.security.hellosecurity.exception.domain.dto.DuplicatedMember;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Users createUser(UserCreate userCreate){
        Users usersByUserId = userRepository.findUsersByUserId(userCreate.getUserId());
        if(usersByUserId != null){
            throw new DuplicatedMember();
        }
        Users user = Users.builder()
                .userId(userCreate.getUserId())
                .password( passwordEncoder.encode(userCreate.getPassword()))
                .email(userCreate.getEmail())
                .build();

        return userRepository.save(user);
    }

}

