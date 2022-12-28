package com.example.ns.domain.user.service;

import com.example.ns.domain.user.domain.User;
import com.example.ns.domain.user.facade.UserFacade;
import com.example.ns.domain.user.present.dto.response.MyPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyPageService {

    private final UserFacade userFacade;

    public MyPageResponse execute() {
        User user = userFacade.getCurrentUser();

        return MyPageResponse.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }
}
