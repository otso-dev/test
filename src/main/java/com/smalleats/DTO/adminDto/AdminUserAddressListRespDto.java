package com.smalleats.DTO.adminDto;

import com.smalleats.entity.UserAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminUserAddressListRespDto {
    private String userRoadAddress;
    private String userDetailAddress;
    private int userZoneCode;
    private String userAddressCategory;
    public AdminUserAddressListRespDto toDto(UserAddress userAddress){
        return AdminUserAddressListRespDto.builder()
                .userRoadAddress(userAddress.getUserRoadAddress())
                .userDetailAddress(userAddress.getUserDetailAddress())
                .userZoneCode(userAddress.getUserZoneCode())
                .build();
    }
}
