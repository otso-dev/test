package com.smalleats.DTO.auth;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JwtTokenRespDto {
    private String grantType;
    private String accessToken;
}
