package com.smalleats.DTO.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtTokenRespDto {
    private String grantType;
    private String accessToken;
}
