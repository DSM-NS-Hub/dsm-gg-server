package com.example.ns.domain.user.exception;

import com.example.ns.global.error.exception.ErrorCode;
import com.example.ns.global.error.exception.ProjectException;

public class AlreadyJoinedException extends ProjectException {

    public static final ProjectException EXCEPTION =
            new AlreadyJoinedException();

    private AlreadyJoinedException() {
        super(ErrorCode.ALREADY_JOINED_EMAIL);
    }
}