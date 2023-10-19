package com.smalleats.DTO.user;

import com.smalleats.entity.UserAddress;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressRespDto {
    private int userAddressId;
    private String userRoadAddress;
    private String userDetailAddress;
    private int userZoneCode;

    public UserAddressRespDto toEntity(UserAddress userAddress){
        return new UserAddressRespDto(
          this.userAddressId = userAddress.getUserAddressId(),
          this.userRoadAddress = userAddress.getUserRoadAddress(),
          this.userDetailAddress = userAddress.getUserDetailAddress(),
          this.userZoneCode = userAddress.getUserZoneCode()
        );
    }
}
