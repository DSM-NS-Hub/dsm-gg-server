package com.example.ns.domain.user.service;

import com.example.ns.domain.user.domain.User;
import com.example.ns.domain.user.facade.UserFacade;
import com.example.ns.domain.user.present.dto.request.UpdateUserInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateUserInfoService {

    private final UserFacade UserFacade;

    @Transactional()
    public void execute(UpdateUserInfoRequest request) {
        User user = UserFacade.getCurrentUser();

        user.update(request);

    }
}