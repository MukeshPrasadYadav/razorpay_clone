package com.codingShuttle.razorpay_clone.payment.service;

import com.codingShuttle.razorpay_clone.payment.dto.request.CreateOrderRequest;
import com.codingShuttle.razorpay_clone.payment.dto.response.OrderResponse;
import org.jspecify.annotations.Nullable;

import java.util.UUID;

public interface OrderService {
    @Nullable OrderResponse create(UUID merchantId, CreateOrderRequest request);
}
