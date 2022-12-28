package com.example.ns.domain.user.present;

import com.example.ns.domain.user.present.dto.request.SignInRequest;
import com.example.ns.domain.user.present.dto.request.SignUpRequest;
import com.example.ns.domain.user.present.dto.request.UpdateUserInfoRequest;
import com.example.ns.domain.user.present.dto.response.MyPageResponse;
import com.example.ns.domain.user.present.dto.response.TokenResponse;
import com.example.ns.domain.user.service.MyPageService;
import com.example.ns.domain.user.service.UpdateUserInfoService;
import com.example.ns.domain.user.service.UserSignInService;
import com.example.ns.domain.user.service.UserSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserSignUpService userSignUpService;
    private final UserSignInService userSignInService;
    private final MyPageService myPageService;
    private final UpdateUserInfoService updateUserInfoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(@RequestBody @Valid SignUpRequest request){
        userSignUpService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse signin(@RequestBody @Valid SignInRequest request) {
        return userSignInService.signIn(request);
    }

    @GetMapping("/mypage")
    public MyPageResponse myPage() {
        return myPageService.execute();
    }

    @PatchMapping("/mypage")
    public void updateMyPage(@RequestBody @Valid UpdateUserInfoRequest request) {
        updateUserInfoService.execute(request);
    }
}
