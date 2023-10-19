package com.smalleats.DTO.orderDTO;


import com.smalleats.entity.OrderMenu;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderMenuReqDto {
    private int menuId;
    private int count;

    public OrderMenu toEntity(int orderId){
        return OrderMenu.builder()
                .foodMenuId(menuId)
                .orderId(orderId)
                .menuNumbers(count)
                .build();
    }
}
