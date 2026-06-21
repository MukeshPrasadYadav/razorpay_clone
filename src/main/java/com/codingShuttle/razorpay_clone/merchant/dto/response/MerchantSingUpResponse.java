package com.codingShuttle.razorpay_clone.merchant.dto.response;

import com.codingShuttle.razorpay_clone.common.Enum.BusinessType;
import com.codingShuttle.razorpay_clone.common.Enum.MerchantStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


public record MerchantSingUpResponse(
        UUID id,
        String name,
        String email,
        String businessName,
        BusinessType businessType,
        MerchantStatus status
) {
}
