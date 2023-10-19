package com.smalleats.DTO.user;

import com.smalleats.entity.UserAddress;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressReqDto {
    private int userAddressId;
    private String userRoadAddress;
    private String userDetailAddress;
    private int userZoneCode;

    public UserAddress toEntity(int userId){
        return UserAddress.builder()
                .userAddressId(userAddressId)
                .userId(userId)
                .userZoneCode(userZoneCode)
                .userDetailAddress(userDetailAddress)
                .userRoadAddress(userRoadAddress)
                .build();
    }
}
