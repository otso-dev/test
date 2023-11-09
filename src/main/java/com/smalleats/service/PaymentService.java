package com.smalleats.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smalleats.DTO.partnerDto.OrderMenuRespDto;
import com.smalleats.DTO.paymentDTO.PaidReqDto;
import com.smalleats.DTO.paymentDTO.PaymentMenuRespDto;
import com.smalleats.DTO.paymentDTO.PaymentOrderRespDto;
import com.smalleats.entity.FoodMenu;
import com.smalleats.entity.FoodProduct;
import com.smalleats.entity.Order;
import com.smalleats.entity.OrderMenu;
import com.smalleats.repository.FoodProductDAO;
import com.smalleats.repository.OrderDAO;
import com.smalleats.repository.PaymentDAO;
import com.smalleats.repository.UserDAO;
import com.smalleats.service.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentDAO paymentDAO;
    private final FoodProductDAO foodProductDAO;
    private final OrderDAO orderDAO;
    private final UserDAO userDAO;

    public PaymentOrderRespDto getOrder(int orderId){
        PaymentOrderRespDto paymentOrderRespDto = new PaymentOrderRespDto();
        Order order = paymentDAO.getOrder(orderId);
        return paymentOrderRespDto.toDto(order);
    }
    public List<PaymentMenuRespDto> getOrderMenuList(int orderId){
        OrderMenu orderMenu = paymentDAO.getOrderMenuList(orderId);
        String menuInfo = orderMenu.getMenuInfo();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(menuInfo, new TypeReference<List<PaymentMenuRespDto>>() {});
        } catch (Exception e) {
            throw new CustomException("JSON 파싱 실패");
        }
    }


    @Transactional
    public int paid(PaidReqDto paidReqDto) throws Exception {
        if(!priceInfoCheck(paidReqDto)){
            cancel(paidReqDto.getOrderId());
            throw new CustomException("가격이 맞지않아 결제가 취소되었습니다.");
        }
//        return paymentDAO.paid(paidReqDto.toEntity());
        return 1;
    }

    public int cancel(int orderId) {
        return paymentDAO.cancel(orderId);
    }

    public boolean priceInfoCheck(PaidReqDto paidReqDto) throws Exception {
        //현재 결제할 orderId를 가져와 주문 정보를 가져옴
        Order order = paymentDAO.getOrder(paidReqDto.getOrderId());
        //orderId를 이용해 해당 음식점의 정보를 가져온다.
        FoodProduct foodProduct = foodProductDAO.getProductDetail(order.getFoodId());
        //orderId를 이용해 주문한 음식메뉴들의 정보를 가져온다.
        OrderMenu orderMenu = orderDAO.getOrderMent(order.getOrderId());
        //가져온 음식메뉴들을 List로 바꾼다.
        List<OrderMenuRespDto> orderMenuList = getOrderList(orderMenu);

        //메뉴들의 총 합 가격을 구함
        int menuTotalPrice = 0;
        for (OrderMenuRespDto orderMenuRespDto : orderMenuList) {
            menuTotalPrice = orderMenuRespDto.getCount() * orderMenuRespDto.getPrice();
        }
        //해당 음식점의 배달비와 메뉴들의 총 합 가격을 더 해 총 가격을 구한다.
        int totalPrice = foodProduct.getFoodDeliveryPrice() + menuTotalPrice;
        //비교
        //배달비 가격이 음식점과 같은지
        if(foodProduct.getFoodDeliveryPrice() != paidReqDto.getPaymentDeliveryPrice()){
            return false;
            //메뉴 총 가격이 주문정보와 같은지
        }else if(menuTotalPrice != paidReqDto.getPaymentMenuPrice()){
            return false;
            //총 가격이 결제요청 정보와 가격이 같은지
        }else return totalPrice == paidReqDto.getPaymentTotalPrice();
    }

    public boolean foodMenuInfoCheck(PaidReqDto paidReqDto) throws Exception {
        //주문한 메뉴들의 정보를 가져온다.
        OrderMenu orderMenu = orderDAO.getOrderMent(paidReqDto.getOrderId());
        //주문한 메뉴들이 해당 음식점에 존재하는지 비교하기 위해 음식점의 메뉴들을 가져온다.
        List<FoodMenu> foodMenuList = foodProductDAO.getFoodMenu(paidReqDto.getFoodId());
        List<OrderMenuRespDto> orderMenuRespDtoList = getOrderList(orderMenu);
        return true;
    }

    private List<OrderMenuRespDto> getOrderList(OrderMenu orderMenu) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(orderMenu.getMenuInfo(), new TypeReference<List<OrderMenuRespDto>>() {});
    }
}
