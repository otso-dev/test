package com.smalleats.entity;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Authority {
    private int authorityId;
    private int roleId;
    private int userId;

    private Role role;
}
