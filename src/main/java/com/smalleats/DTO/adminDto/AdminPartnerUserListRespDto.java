package com.smalleats.DTO.adminDto;

import com.smalleats.entity.PartnerUser;
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
    private String partnerPhoneNumber;
    private String partnerBusinessName;
    private String foodName;
    private String pendingStatus;
    private String roleName;

    public AdminPartnerUserListRespDto toDto(PartnerUser partnerUser){
        return AdminPartnerUserListRespDto.builder()
                .partnerId(partnerUser.getPartnerId())
                .partnerUserName(partnerUser.getPartnerUserName())
                .partnerUserEmail(partnerUser.getPartnerUserEmail())
                .partnerPhoneNumber(partnerUser.getPartnerPhoneNumber())
                .partnerBusinessName(partnerUser.getPartnerBusinessName())
                .foodName(partnerUser.getPendingFood().getFoodName())
                .pendingStatus(partnerUser.getPendingFood().getPendingStatus())
                .roleName(partnerUser.getRole().getRoleName())
                .build();
    }
}
