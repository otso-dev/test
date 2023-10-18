package com.smalleats.DTO.user;

import com.smalleats.entity.UserAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressReqDto {
    private int userAddressId;
    private String userRoadAddress;
    private String userDetailAddress;
    private int userZoneCode;

    public UserAddress toEntity(){
        return UserAddress.builder()
                .userAddressId(userAddressId)
                .userZoneCode(userZoneCode)
                .userDetailAddress(userDetailAddress)
                .userRoadAddress(userRoadAddress)
                .build();
    }
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
