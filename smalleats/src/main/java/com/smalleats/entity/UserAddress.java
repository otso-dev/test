package com.smalleats.entity;

import com.smalleats.DTO.user.UserAddressRespDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress {
    private int userAddressId;
    private int userId;
    private String userRoadAddress;
    private String userDetailAddress;
    private int userZoneCode;

    private User user;
    public UserAddressRespDto toDto(){
        return UserAddressRespDto.builder()
                .userAddressId(userAddressId)
                .userRoadAddress(userRoadAddress)
                .userDetailAddress(userDetailAddress)
                .userZoneCode(userZoneCode)
                .build();
    }
}
