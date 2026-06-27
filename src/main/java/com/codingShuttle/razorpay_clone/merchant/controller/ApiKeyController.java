package com.codingShuttle.razorpay_clone.merchant.controller;


import com.codingShuttle.razorpay_clone.merchant.dto.request.ApiKeyRequest;
import com.codingShuttle.razorpay_clone.merchant.dto.response.ApiKeyResponse;
import com.codingShuttle.razorpay_clone.merchant.entity.ApiKey;
import com.codingShuttle.razorpay_clone.merchant.service.ApiKeyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/merchants/{merchantId}/api-key")
@RequiredArgsConstructor
public class ApiKeyController {

    private final ApiKeyService apiKeyService;

    @PostMapping
    public ResponseEntity<ApiKeyResponse> createApiKey(@PathVariable UUID merchantId, @RequestBody @Valid ApiKeyRequest request){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apiKeyService.create(merchantId,request));

    }

    @GetMapping
    public ResponseEntity<List<ApiKeyResponse>> listByMerchant(@PathVariable UUID merchantId){

        return ResponseEntity.ok(apiKeyService.listByMerchant(merchantId));
    }

        @DeleteMapping("/{keyId}")
        public ResponseEntity<Void> revokeApiKey(@PathVariable UUID merchantId,@PathVariable UUID keyId){

            apiKeyService.revoke(merchantId,keyId);
            return ResponseEntity.noContent().build();
        }

    @PostMapping("/rotate/{keyId}")
    public ResponseEntity<ApiKeyResponse> rotate(@PathVariable UUID merchantId, @PathVariable UUID keyId){

        return ResponseEntity.status(HttpStatus.OK)
                .body(apiKeyService.rotate(merchantId,keyId));
    }
}
