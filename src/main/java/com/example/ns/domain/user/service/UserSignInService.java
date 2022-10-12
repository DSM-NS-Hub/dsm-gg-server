package com.example.ns.domain.user.service;

import antlr.Token;
import com.example.ns.domain.user.domain.User;
import com.example.ns.domain.user.domain.repository.UserRepository;
import com.example.ns.domain.user.exception.PasswordMisMatchException;
import com.example.ns.domain.user.exception.UserNotFoundException;
import com.example.ns.domain.user.present.dto.request.SignInRequest;
import com.example.ns.domain.user.present.dto.response.TokenResponse;
import com.example.ns.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserSignInService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional(readOnly = true)
    public TokenResponse signIn(SignInRequest request){
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw PasswordMisMatchException.EXCEPTION;
        }

        String access = jwtTokenProvider.generateAccessToken(request.getEmail());

        return TokenResponse.builder()
                .accessToken(access)
                .authority(user.getAuthority())
                .build();
    }
}
