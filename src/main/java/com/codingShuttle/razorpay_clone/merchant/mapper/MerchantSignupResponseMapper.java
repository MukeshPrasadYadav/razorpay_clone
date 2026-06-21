package com.codingShuttle.razorpay_clone.merchant.mapper;


import com.codingShuttle.razorpay_clone.merchant.dto.response.MerchantSingUpResponse;
import com.codingShuttle.razorpay_clone.merchant.entity.Merchant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MerchantSignupResponseMapper {

    MerchantSingUpResponse toResponse(Merchant merchant);
}
