package com.smalleats.entity;

import com.smalleats.security.PrincipalUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private String profileImg;
    private String provider;

    private List<Authority> authorities;

    public PrincipalUser toPrincipal(){
        return PrincipalUser.builder()
                .userId(userId)
                .userName(userName)
                .email(email)
                .password(password)
                .authorities(authorities)
                .provider(provider)
                .build();
    }
}
