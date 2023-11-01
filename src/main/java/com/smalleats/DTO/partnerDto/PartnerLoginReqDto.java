package com.smalleats.DTO.partnerDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PartnerLoginReqDto {
    private String partnerUserEmail;
    private String partnerUserPassword;
}
