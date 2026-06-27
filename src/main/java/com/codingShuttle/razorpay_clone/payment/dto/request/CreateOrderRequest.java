package com.codingShuttle.razorpay_clone.payment.dto.request;

import com.codingShuttle.razorpay_clone.common.Entity.Money;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Map;

public record CreateOrderRequest(
        @NotNull(message = "Amount is required.")
        Money amount,

        @Size(max = 100)
        String receipt,

        Map<String,Object> notes,

        LocalDateTime expiresAt
) {
}
