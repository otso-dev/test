package com.smalleats.DTO.auth;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserRespDto {
    private int userId;
    private String email;
    private String userName;
    private String phoneNumber;
    private String authorities;
}
