package com.smalleats.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Authority {
    private int authorityId;
    private int roleId;
    private int userId;

    private Role role;
}
