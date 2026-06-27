package com.codingShuttle.razorpay_clone.merchant.mapper;

import com.codingShuttle.razorpay_clone.merchant.dto.response.ApiKeyResponse;
import com.codingShuttle.razorpay_clone.merchant.entity.ApiKey;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MerchantApiKeyResponseMapper {

    ApiKeyResponse toResponse(ApiKey apiKey);

}
