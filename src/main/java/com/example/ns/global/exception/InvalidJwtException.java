package com.example.ns.global.exception;

import com.example.ns.global.error.exception.ErrorCode;
import com.example.ns.global.error.exception.ProjectException;

public class InvalidJwtException extends ProjectException {
    public static final InvalidJwtException EXCEPTION =
            new InvalidJwtException();

    public InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}
