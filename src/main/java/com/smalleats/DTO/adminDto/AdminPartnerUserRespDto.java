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
public class AdminPartnerUserRespDto {
    private String partnerUserName;
    private String partnerUserEmail;
    private String partnerBusinessName;
    private String partnerPhoneNumber;
    private int partnerBusinessNumber;
    public AdminPartnerUserRespDto toDto(PartnerUser partnerUser){
        return AdminPartnerUserRespDto.builder()
                .partnerUserName(partnerUser.getPartnerUserName())
                .partnerUserEmail(partnerUser.getPartnerUserEmail())
                .partnerBusinessName(partnerUser.getPartnerBusinessName())
                .partnerPhoneNumber(partnerUser.getPartnerPhoneNumber())
                .partnerBusinessNumber(partnerUser.getPartnerBusinessNumber())
                .build();
    }
}
