package com.codingShuttle.razorpay_clone.merchant.service.impl;

import com.codingShuttle.razorpay_clone.common.exceptions.ResourceNotFoundException;
import com.codingShuttle.razorpay_clone.merchant.dto.request.ApiKeyRequest;
import com.codingShuttle.razorpay_clone.merchant.dto.response.ApiKeyResponse;
import com.codingShuttle.razorpay_clone.merchant.entity.ApiKey;
import com.codingShuttle.razorpay_clone.merchant.entity.Merchant;
import com.codingShuttle.razorpay_clone.merchant.repository.ApiKeyRepository;
import com.codingShuttle.razorpay_clone.merchant.repository.MerchantRepository;
import com.codingShuttle.razorpay_clone.merchant.service.ApiKeyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Slf4j
@RequiredArgsConstructor
public class ApiKeyServiceImpl implements ApiKeyService {

    private final ApiKeyRepository apiKeyRepository;
    private final MerchantRepository merchantRepository;


    @Override
    public ApiKeyResponse create(UUID merchantId, ApiKeyRequest request) {

        Merchant merchant = merchantRepository.findById(merchantId)
                .orElseThrow(() -> new ResourceNotFoundException("merchant",merchantId));

        String keyId = "rzp_"+request.environment().name().toUpperCase()+"random_big_stringn";
        String hashKey = "random_Secret_ke";

        ApiKey apiKey = ApiKey.builder()
                .keyId(keyId)
                .keyHash(hashKey) // encode this
                .environment(request.environment())
                .merchant(merchant)
                .build();

        apiKeyRepository.save(apiKey);

        return new ApiKeyResponse(merchantId,keyId,hashKey,request.environment());

    }
}
