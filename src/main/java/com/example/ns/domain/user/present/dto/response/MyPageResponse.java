package com.example.ns.domain.user.present.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MyPageResponse {

    private final String email;
    private final String username;

}
