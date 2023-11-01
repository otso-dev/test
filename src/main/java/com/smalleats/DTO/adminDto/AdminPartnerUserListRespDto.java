package com.smalleats.DTO.adminDto;

import com.smalleats.entity.PartnerUser;
import com.smalleats.entity.PendingFood;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminPartnerUserListRespDto {
    private int partnerId;
    private String partnerUserName;
    private String partnerUserEmail;
    private String roleName;

    public AdminPartnerUserListRespDto toDto(PartnerUser partnerUser){

        return AdminPartnerUserListRespDto.builder()
                .partnerId(partnerUser.getPartnerId())
                .partnerUserName(partnerUser.getPartnerUserName())
                .partnerUserEmail(partnerUser.getPartnerUserEmail())
                .roleName(partnerUser.getRole().getRoleName())
                .build();
    }
}
