package com.example.ns.global.exception;

import com.example.ns.global.error.exception.ErrorCode;
import com.example.ns.global.error.exception.ProjectException;

public class ExpiredJwtException extends ProjectException {
    public static final ExpiredJwtException EXCEPTION =
            new ExpiredJwtException();

    public ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}
