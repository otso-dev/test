package com.smalleats.entity;

import com.smalleats.DTO.user.UserInfoRespDto;
import com.smalleats.security.PrincipalUser;
import lombok.*;

import java.util.List;
@Getter
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
                .phoneNumber(phoneNumber)
                .authorities(authorities)
                .provider(provider)
                .build();
    }
    public UserInfoRespDto toUserInfoRespDto(){
        return UserInfoRespDto.builder()
                .username(userName)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
    }
}
