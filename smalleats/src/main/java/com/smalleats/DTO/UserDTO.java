package com.smalleats.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private String userName;
    private String password;
    private String phoneNumber;
    private String userKind;
    private String provider;
}
