package com.smalleats.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartnerAuthority {
    private int partnerAuthorityId;
    private int partnerId;
    private int roleId;

    private Role role;
}
