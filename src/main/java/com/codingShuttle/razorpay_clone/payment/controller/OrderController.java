package com.codingShuttle.razorpay_clone.payment.controller;


import com.codingShuttle.razorpay_clone.payment.dto.request.CreateOrderRequest;
import com.codingShuttle.razorpay_clone.payment.dto.response.OrderResponse;
import com.codingShuttle.razorpay_clone.payment.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderController {


    private final OrderService orderService;

    UUID merchantId = UUID.fromString("3f8b4d76-9f61-4d7e-9c83-2d7b6f1a5e94");


    // Todo pass   a merchant id in controller parametter
    @PostMapping
    public ResponseEntity<OrderResponse> create( @RequestBody CreateOrderRequest request){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderService.create(merchantId,request));

    }
}
