package com.example.ns.domain.user.exception;

import com.example.ns.global.error.exception.ErrorCode;
import com.example.ns.global.error.exception.ProjectException;

public class ExistUsernameException extends ProjectException {
    public static final ExistUsernameException EXCEPTION =
            new ExistUsernameException();

    public ExistUsernameException(){
        super(ErrorCode.ALREADY_JOINED_USERNAME);
    }
}
