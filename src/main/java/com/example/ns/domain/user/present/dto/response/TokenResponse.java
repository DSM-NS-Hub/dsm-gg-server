package com.example.ns.domain.user.present.dto.response;

import com.example.ns.global.enums.Authority;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponse {
    private final String accessToken;
    private final String refreshToken;
    private final Authority authority;
}
