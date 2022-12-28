package com.example.ns.domain.user.domain;

import com.example.ns.domain.user.present.dto.request.UpdateUserInfoRequest;
import com.example.ns.global.enums.Authority;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    @Size(min = 8, max = 50)
    private String email;

    @Column
    @NotNull
    @Size(min = 8)
    private String password;

    @Column(unique = true)
    @NotNull
    private String username;

    @Column
    @NotNull
    private Authority authority;

    @Builder
    public User(Long id, String email, String password, String username, Authority authority){
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.authority = authority;
    }

    public void update(UpdateUserInfoRequest request) {
        this.username = request.getUsername();
    }
}
