package com.example.ns.domain.user.exception;

import com.example.ns.global.error.exception.ErrorCode;
import com.example.ns.global.error.exception.ProjectException;

public class UserNotFoundException extends ProjectException {
    public static final UserNotFoundException EXCEPTION =
            new UserNotFoundException();

    public UserNotFoundException(){
        super(ErrorCode.USER_NOT_FOUND);
    }
}
