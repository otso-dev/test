package com.smalleats.DTO.user;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PasswordReqDto {
    private String currentPassword;
    private String changePassword;
    private String checkPassword;
}
