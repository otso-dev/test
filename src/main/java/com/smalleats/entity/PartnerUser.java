package com.smalleats.entity;

import com.smalleats.security.PrincipalUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartnerUser {
    private int partnerId;
    private String partnerUserName;
    private String partnerPassword;
    private String partnerUserEmail;
    private String partnerPhoneNumber;
    private String partnerBusinessName;
    private int partnerBusinessNumber;

    private List<Authority> authorities;

    private Authority authority;
    private Role role;
    private PendingFood pendingFood;


    public PrincipalUser toPrincipal(){
        return PrincipalUser.builder()
                .partnerId(partnerId)
                .partnerUserName(partnerUserName)
                .partnerUserEmail(partnerUserEmail)
                .partnerPassword(partnerPassword)
                .authorities(authorities)
                .isUser(false)
                .build();
    }
}
