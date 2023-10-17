package com.smalleats.controller;


import com.smalleats.repository.PaymentDAO;
import com.smalleats.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @RequestMapping(value = "/payment/order", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct(){
        return ResponseEntity.ok(true);
    }
}
