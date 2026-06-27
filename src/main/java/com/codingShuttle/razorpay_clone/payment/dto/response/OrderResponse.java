package com.codingShuttle.razorpay_clone.payment.dto.response;

import com.codingShuttle.razorpay_clone.common.Entity.Money;
import com.codingShuttle.razorpay_clone.common.Enum.OrderStatus;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public record OrderResponse(
        UUID id,
        UUID merchantId,

        String receipt,
        Money amount,
        OrderStatus status,
        Integer attempts,
        Map<String,Object> notes,
        LocalDateTime expiresAt,
        LocalDateTime createdAt
) {
}
