package com.smalleats.DTO.auth;

import lombok.*;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthoritiesRespDto {
    private String userName;
    private String authorities;
}
