package com.smalleats.DTO.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthUserRespDto {
    private int userId;
    private String email;
    private String userName;
    private String phoneNumber;
    private String authorities;
}
