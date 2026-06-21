package com.codingShuttle.razorpay_clone.merchant.service.impl;

import com.codingShuttle.razorpay_clone.common.Enum.MerchantStatus;
import com.codingShuttle.razorpay_clone.common.Enum.Role;
import com.codingShuttle.razorpay_clone.common.exceptions.DuplicateResourceException;
import com.codingShuttle.razorpay_clone.merchant.dto.request.MerchantSignUpRequest;
import com.codingShuttle.razorpay_clone.merchant.dto.response.MerchantSingUpResponse;
import com.codingShuttle.razorpay_clone.merchant.entity.AppUser;
import com.codingShuttle.razorpay_clone.merchant.entity.Merchant;
import com.codingShuttle.razorpay_clone.merchant.mapper.MerchantSignupResponseMapper;
import com.codingShuttle.razorpay_clone.merchant.repository.AppUserRepository;
import com.codingShuttle.razorpay_clone.merchant.repository.MerchantRepository;
import com.codingShuttle.razorpay_clone.merchant.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AppUserRepository appUserRepository;

    private final MerchantRepository merchantRepository;
    private final MerchantSignupResponseMapper merchantSignupResponseMapper;


    @Override
    @Transactional
    public MerchantSingUpResponse signup(MerchantSignUpRequest request) {
        if(merchantRepository.existsByEmail(request.email())) throw  new DuplicateResourceException("DUPLICATE_MERCHANT_EMAIL","Merchant already exits by email:"+request.email());

        Merchant merchant = Merchant.builder()
                .businessName(request.businessName())
                .businessType(request.businessType())
                .email(request.email())
                .name(request.name())
                .status(MerchantStatus.PENDING_KYC)
                .build();

        merchantRepository.save(merchant);

        AppUser appUser = AppUser.builder()
                .email(request.email())
                .merchant(merchant)
                .role(Role.OWNER)
                .passwordHash(request.password())  // hash password todo
                .build();

        appUserRepository.save(appUser);

        return merchantSignupResponseMapper.toResponse(merchant);
    }
}
