package com.codingShuttle.razorpay_clone.merchant.dto.response;

import com.codingShuttle.razorpay_clone.common.Enum.Environment;

import java.util.UUID;

public record ApiKeyResponse(
        UUID id,
        String keyId,
        String hashKey,
        Environment environment
) {
}
