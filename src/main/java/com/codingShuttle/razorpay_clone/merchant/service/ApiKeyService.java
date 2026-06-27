package com.codingShuttle.razorpay_clone.merchant.service;

import com.codingShuttle.razorpay_clone.merchant.dto.request.ApiKeyRequest;
import com.codingShuttle.razorpay_clone.merchant.dto.response.ApiKeyResponse;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public interface ApiKeyService {
     ApiKeyResponse create(UUID merchantId, @Valid ApiKeyRequest request);
     List<ApiKeyResponse> listByMerchant(UUID merchantId);

    void revoke(UUID merchantId, UUID keyId);

    @Nullable ApiKeyResponse rotate(UUID merchantId, UUID keyId);
}
