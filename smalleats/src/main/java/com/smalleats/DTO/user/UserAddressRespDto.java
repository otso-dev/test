package com.smalleats.DTO.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAddressRespDto {
    private int userAddressId;
    private String userRoadAddress;
    private String userDetailAddress;
    private int userZoneCode;
}
