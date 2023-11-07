package com.smalleats.DTO.user;

import com.smalleats.entity.UserAddress;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressRespDto {
    private int userAddressId;
    private String userRoadAddress;
    private String userDetailAddress;
    private String userAddressCategory;
    private String userAddressSiGunGu;
    private int userZoneCode;
    private int userAddressFlag;

    public UserAddressRespDto toDto(UserAddress userAddress){
        return UserAddressRespDto.builder()
                .userAddressId(userAddress.getUserAddressId())
                .userRoadAddress(userAddress.getUserRoadAddress())
                .userDetailAddress(userAddress.getUserDetailAddress())
                .userZoneCode(userAddress.getUserZoneCode())
                .userAddressCategory(userAddress.getUserAddressCategory())
                .userAddressFlag(userAddress.getUserAddressFlag())
                .userAddressSiGunGu(userAddress.getUserAddressSigungu())
                .build();
    }
}
