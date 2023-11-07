package com.smalleats.DTO.user;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginReqDto {
    private String email;
    private String password;
    private String role;
}
