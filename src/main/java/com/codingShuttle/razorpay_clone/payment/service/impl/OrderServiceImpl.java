package com.codingShuttle.razorpay_clone.payment.service.impl;


import com.codingShuttle.razorpay_clone.common.Enum.OrderStatus;
import com.codingShuttle.razorpay_clone.common.exceptions.DuplicateResourceException;
import com.codingShuttle.razorpay_clone.payment.dto.request.CreateOrderRequest;
import com.codingShuttle.razorpay_clone.payment.dto.response.OrderResponse;
import com.codingShuttle.razorpay_clone.payment.entity.OrderRecord;
import com.codingShuttle.razorpay_clone.payment.repository.OrderRepository;
import com.codingShuttle.razorpay_clone.payment.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Value("${payment.order.default-order-expiry-minutes:30}")
    private int defaultOrderExpiryMinutes;

    @Override
    public @Nullable OrderResponse create(UUID merchantId, CreateOrderRequest request) {

        log.info("Creating order with receipt {}",request.receipt());
        if( request.receipt() != null && orderRepository.existsByMerchantIdAndReceipt(merchantId,request.receipt())){
            log.error("Order with the receipt {} already exist.",request.receipt());
            throw  new DuplicateResourceException("ORDER_RECEIPT_DUPLICATE","Order with this receipt already exists.");
        }

        OrderRecord order = OrderRecord.builder()
                .merchantId(merchantId)
                .amount(request.amount())
                .receipt(request.receipt())
                .notes(request.notes())
                .orderStatus(OrderStatus.CREATED)
                .expiresAt(request.expiresAt() != null ? request.expiresAt() : LocalDateTime.now().plusMinutes(defaultOrderExpiryMinutes))
                .build();

        orderRepository.save(order);
        //Todo add kafka event about order publish

        log.info("Sucessfully created order with receipt {} and orderId {} for merchantId",request.receipt(),order.getId(),merchantId);

        return new OrderResponse(order.getId(),merchantId,
                order.getReceipt(), order.getAmount(),
                order.getOrderStatus(),order.getAttempts(),
                order.getNotes(),order.getExpiresAt(),order.getCreatedAt());
    }
}
