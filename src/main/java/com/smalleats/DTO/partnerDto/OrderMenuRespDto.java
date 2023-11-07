package com.smalleats.DTO.partnerDto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smalleats.entity.OrderMenu;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderMenuRespDto {
    private int menuId;
    private int count;
    private int price;
    private String menuName;
}
