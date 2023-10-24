package com.smalleats.entity;

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
    private String userAddressSido;
    private String userAddressSigungu;
    private String userAddressCategory;
    private int userZoneCode;

    private User user;


}
