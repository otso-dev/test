package com.smalleats.DTO.partnerDto;

import com.smalleats.entity.PartnerUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartnerRegisterReqDto {
    private String partnerUserName;
    private String partnerPassword;
    private String partnerUserEmail;
    private String partnerPhoneNumber;
    private String partnerBusinessName;
    private int partnerBusinessNumber;

    public PartnerUser toEntity(){
        return PartnerUser.builder()
                .partnerUserName(partnerUserName)
                .partnerPassword(new BCryptPasswordEncoder().encode(partnerPassword))
                .partnerUserEmail(partnerUserEmail)
                .partnerPhoneNumber(partnerPhoneNumber)
                .partnerBusinessName(partnerBusinessName)
                .partnerBusinessNumber(partnerBusinessNumber)
                .build();
    }
}
