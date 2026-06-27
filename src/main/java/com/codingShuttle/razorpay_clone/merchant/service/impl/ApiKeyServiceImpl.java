package com.codingShuttle.razorpay_clone.merchant.service.impl;

import com.codingShuttle.razorpay_clone.common.exceptions.ResourceNotFoundException;
import com.codingShuttle.razorpay_clone.common.util.RandomizerUtil;
import com.codingShuttle.razorpay_clone.merchant.dto.request.ApiKeyRequest;
import com.codingShuttle.razorpay_clone.merchant.dto.response.ApiKeyResponse;
import com.codingShuttle.razorpay_clone.merchant.entity.ApiKey;
import com.codingShuttle.razorpay_clone.merchant.entity.Merchant;
import com.codingShuttle.razorpay_clone.merchant.mapper.MerchantApiKeyResponseMapper;
import com.codingShuttle.razorpay_clone.merchant.repository.ApiKeyRepository;
import com.codingShuttle.razorpay_clone.merchant.repository.MerchantRepository;
import com.codingShuttle.razorpay_clone.merchant.service.ApiKeyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class ApiKeyServiceImpl implements ApiKeyService {

    private final ApiKeyRepository apiKeyRepository;
    private final MerchantRepository merchantRepository;
    private final MerchantApiKeyResponseMapper apiKeyResponseMapper;



    @Override
    @Transactional
    public ApiKeyResponse create(UUID merchantId, ApiKeyRequest request) {

        Merchant merchant = merchantRepository.findById(merchantId)
                .orElseThrow(() -> new ResourceNotFoundException("merchant",merchantId));

        String keyId = "rzp_"+request.environment().name().toUpperCase()+ RandomizerUtil.base64(24);
        String keySecretHash = RandomizerUtil.base64(40);

        ApiKey apiKey = ApiKey.builder()
                .keyId(keyId)
                .keySecretHash(keySecretHash) // encode this
                .environment(request.environment())
                .merchant(merchant)
                .build();

        apiKeyRepository.save(apiKey);

       // return new ApiKeyResponse(merchantId,keyId,keySecretHash,request.environment(),apiKey.isEnabled(),null,null);

        return apiKeyResponseMapper.toResponse(apiKey);

    }

    @Override
        public List<ApiKeyResponse> listByMerchant(UUID merchantId) {

        merchantRepository.findById(merchantId)
                .orElseThrow(() -> new ResourceNotFoundException("merchant",merchantId));

           return apiKeyRepository.findByMerchant_Id(merchantId).stream()
                   .map(apiKey -> apiKeyResponseMapper.toResponse(apiKey))
                   .collect(Collectors.toList());
        }

    @Override
    @Transactional
    public void revoke(UUID merchantId, UUID keyId) {

        ApiKey apiKey = apiKeyRepository.findById(keyId)
                        .filter(k -> k.getMerchant().getId().equals(merchantId))
                                .orElseThrow(()-> new ResourceNotFoundException("ApiKey",keyId));

        apiKey.setEnabled(false);

        apiKeyRepository.save(apiKey);
    }

    @Override
    public @Nullable ApiKeyResponse rotate(UUID merchantId, UUID keyId) {
        ApiKey apiKey = apiKeyRepository.findById(keyId)
                .filter(k -> k.getMerchant().getId().equals(merchantId))
                .orElseThrow(()-> new ResourceNotFoundException("ApiKey",keyId));

        String newRawSecret = RandomizerUtil.base64(40);
        apiKey.setPreviousSecretHash(apiKey.getKeySecretHash());
        apiKey.setKeySecretHash(newRawSecret);
        apiKey.setRotatedAt(LocalDateTime.now());
        apiKey.setGraceNoticePeriod(LocalDateTime.now().plusHours(24));

        apiKeyRepository.save(apiKey);
        return apiKeyResponseMapper.toResponse(apiKey);
    }
}
