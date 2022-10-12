package com.example.ns.domain.user.service;

import com.example.ns.domain.user.domain.User;
import com.example.ns.domain.user.domain.repository.UserRepository;
import com.example.ns.domain.user.exception.AlreadyJoinedException;
import com.example.ns.domain.user.exception.ExistUsernameException;
import com.example.ns.domain.user.present.dto.request.SignUpRequest;
import com.example.ns.global.enums.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSignUpService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(SignUpRequest request){
        if (userRepository.findByEmail(request.getEmail()).isPresent())
            throw AlreadyJoinedException.EXCEPTION;

        else if (userRepository.findByUsername(request.getUsername()).isPresent())
            throw ExistUsernameException.EXCEPTION;


        userRepository.save(
                User.builder()
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .username(request.getUsername())
                        .authority(Authority.USER)
                        .build()
        );
    }

}
