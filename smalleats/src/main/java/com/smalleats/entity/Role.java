package com.smalleats.entity;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private int roleId;
    private String roleName;
}
