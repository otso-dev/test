package com.smalleats.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder //테스트용 배포시 삭제 필요
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authority {
    private int authorityId;
    private int roleId;
    private int userId;

    private Role role;
}
