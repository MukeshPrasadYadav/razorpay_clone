package com.codingShuttle.razorpay_clone.merchant.dto.response;

import com.codingShuttle.razorpay_clone.common.Enum.Environment;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiKeyResponse(
        UUID id,
        String keyId,
        String keySecretHash,
        Environment environment,
        boolean enabled,
        LocalDateTime lastUpdatedAt,
        LocalDateTime createdAt
) {
}
