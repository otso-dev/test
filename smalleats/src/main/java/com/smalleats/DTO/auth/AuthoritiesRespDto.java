package com.smalleats.DTO.auth;

import com.smalleats.entity.Authority;
import lombok.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthoritiesRespDto {
    private String userName;
    private String authorities;
}
