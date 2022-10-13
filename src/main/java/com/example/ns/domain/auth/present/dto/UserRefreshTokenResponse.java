package com.example.ns.domain.auth.present.dto;

import com.example.ns.global.enums.Authority;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRefreshTokenResponse {
    private final String accessToken;
    private final String refreshToken;
    private final Authority authority;
}
