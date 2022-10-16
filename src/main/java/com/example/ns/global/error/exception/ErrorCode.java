package com.example.ns.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    POST_NOTFOUND(404, "POST-404-1", "Posts Not Found"),
    INVALID_JWT(401, "JWT-401-1", "Invalid Jwt"),
    EXPIRED_JWT(401, "JWT-401-2", "Expired JWT"),
    PASSWORD_NOT_MATCH(401, "AUTH-401-1", "Password Not Match"),
    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),

    ALREADY_JOINED_EMAIL(409, "USER-409-1", "Email Already Joined"),
    ALREADY_JOINED_USERNAME(409, "USER-409-2", "Username Already Exist"),

    REFRESH_NOT_FOUND(404, "JWT-404-1", "RefreshToken Not Found");

    private final int status;
    private final String code;
    private final String message;
}
