package com.smalleats.controller;


import com.smalleats.DTO.paymentDTO.PaidReqDto;
import com.smalleats.repository.PaymentDAO;
import com.smalleats.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @RequestMapping(value = "/payment/paymentpage/paid", method = RequestMethod.POST)
    public ResponseEntity<?> paid(@RequestBody PaidReqDto paidReqDto)
    {
        return ResponseEntity.ok(paymentService.paid(paidReqDto));
    }
}
