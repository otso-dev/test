package com.smalleats.DTO.orderDTO;


import com.smalleats.entity.OrderMenu;
import lombok.*;
import org.json.simple.JSONObject;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderMenuReqDto {
    private int menuId;
    private String menuName;
    private int count;
    private int price;

    public OrderMenu toEntity(int orderId, JSONObject jsonObject) {
        return OrderMenu.builder()
                .orderId(orderId)
                .menuInfo(jsonObject.toJSONString())
                .build();
    }
}

