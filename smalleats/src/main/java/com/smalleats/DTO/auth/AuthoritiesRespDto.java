package com.smalleats.DTO.auth;

import com.smalleats.entity.Authority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthoritiesRespDto {
    private String userName;
    private List<String> authorities;
}
