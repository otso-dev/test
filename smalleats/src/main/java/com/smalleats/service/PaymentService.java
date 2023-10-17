package com.smalleats.service;

import com.smalleats.DTO.foodProductDTO.ProductDetailRespDto;
import com.smalleats.entity.FoodProduct;
import com.smalleats.entity.Order;
import com.smalleats.repository.FoodProductDAOImpl;
import com.smalleats.repository.PaymentDAOImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentDAOImpl paymentDAO;
    private final FoodProductDAOImpl foodProductDAO;

    public Order getOrder(int orderId){
        

    }

}
