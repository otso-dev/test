package com.smalleats.DTO.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressReqDto {
    private String userRoadAddress;
    private String userDetailAddress;
    private int userZoneCode;
}
