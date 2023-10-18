package com.smalleats.DTO.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PasswordReqDto {
    private String currentPassword;
    private String changePassword;
    private String checkPassword;
}
