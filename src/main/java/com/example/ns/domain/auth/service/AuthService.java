package com.example.ns.domain.auth.service;

import com.example.ns.domain.auth.domain.RefreshToken;
import com.example.ns.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.ns.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.ns.domain.auth.present.dto.UserRefreshTokenResponse;
import com.example.ns.domain.user.domain.User;
import com.example.ns.domain.user.facade.UserFacade;
import com.example.ns.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserFacade userFacade;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public UserRefreshTokenResponse reissue(String refreshToken){
        User user = userFacade.getCurrentUser();

        if(!jwtTokenProvider.getTokenBody(refreshToken).get("type").equals("refresh"))
            throw RefreshTokenNotFoundException.EXCEPTION;

        RefreshToken refreshTokenOne = refreshTokenRepository.findByToken(refreshToken)
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        String newRefreshToken = jwtTokenProvider.generateRefreshToken(refreshTokenOne.getEmail());
        refreshTokenOne.updateToken(newRefreshToken);

        String accessToken = jwtTokenProvider.generateAccessToken(refreshTokenOne.getEmail());

        return UserRefreshTokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .authority(user.getAuthority())
                .build();
    }
}
