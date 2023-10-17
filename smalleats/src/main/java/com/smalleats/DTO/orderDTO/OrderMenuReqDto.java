package com.smalleats.DTO.orderDTO;


import com.smalleats.entity.OrderMenu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderMenuReqDto {
    private int menuId;
    private int orderId;
    private int count;

    public OrderMenu toEntity(){
        OrderMenu orderMenu = new OrderMenu();
        orderMenu.setOrderId(orderId);
        orderMenu.setFoodMenuId(menuId);
        orderMenu.setMenuNumbers(count);
        return orderMenu;
    }
}
