package com.smalleats.controller;


import com.smalleats.DTO.paymentDTO.PaidReqDto;
import com.smalleats.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @RequestMapping(value = "/payment/paymentpage/paid", method = RequestMethod.POST)
    public ResponseEntity<?> paid(@RequestBody PaidReqDto paidReqDto) throws Exception {
        return ResponseEntity.ok(paymentService.paid(paidReqDto));
    }

    @RequestMapping(value = "/payment/paymentpage/cancel/{orderId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> cancel(@PathVariable int orderId){
        System.out.println(orderId);
        return ResponseEntity.ok(paymentService.cancel(orderId));
    }
}
