package com.smalleats.entity;

import com.smalleats.DTO.user.UserAddressReqDto;
import com.smalleats.DTO.user.UserAddressRespDto;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress {
    private int userAddressId;
    private int userId;
    private String userRoadAddress;
    private String userDetailAddress;
    private int userZoneCode;

    private User user;

    public UserAddressRespDto toAddressRespDto() {
        return UserAddressRespDto.builder()
                .userAddressId(userAddressId)
                .userRoadAddress(userRoadAddress)
                .userDetailAddress(userDetailAddress)
                .userZoneCode(userZoneCode)
                .build();
    }

}
