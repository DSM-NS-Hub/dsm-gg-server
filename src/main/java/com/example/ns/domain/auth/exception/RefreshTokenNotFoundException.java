package com.example.ns.domain.auth.exception;

import com.example.ns.global.error.exception.ErrorCode;
import com.example.ns.global.error.exception.ProjectException;

public class RefreshTokenNotFoundException extends ProjectException {
    public static final RefreshTokenNotFoundException EXCEPTION =
            new RefreshTokenNotFoundException();

    public RefreshTokenNotFoundException() {
        super(ErrorCode.REFRESH_NOT_FOUND);
    }
}
