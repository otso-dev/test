package com.smalleats.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userName;
    private String password;
    private String phoneNumber;
    private String userKind;
    private String profileImg;
    private String provider;
}
