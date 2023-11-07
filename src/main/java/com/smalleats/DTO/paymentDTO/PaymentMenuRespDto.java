package com.smalleats.DTO.paymentDTO;


import com.smalleats.entity.OrderMenu;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMenuRespDto {
    private int count;
    private int price;
    private int menuId;
    private String menuName;
    private String menuInfo;
    
}
