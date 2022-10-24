package com.example.ns.domain.record.present.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class SearchUserRequest {

    @NotBlank(message = "username은 Null을 허용하지 않습니다.")
    private String username;
}
