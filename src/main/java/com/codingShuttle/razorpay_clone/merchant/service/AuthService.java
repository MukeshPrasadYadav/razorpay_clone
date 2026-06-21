package com.codingShuttle.razorpay_clone.merchant.service;

import com.codingShuttle.razorpay_clone.merchant.dto.request.MerchantSignUpRequest;
import com.codingShuttle.razorpay_clone.merchant.dto.response.MerchantSingUpResponse;

public interface AuthService {

    MerchantSingUpResponse signup(MerchantSignUpRequest request);
}
