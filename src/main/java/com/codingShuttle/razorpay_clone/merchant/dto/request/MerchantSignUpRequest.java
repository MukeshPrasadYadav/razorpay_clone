package com.codingShuttle.razorpay_clone.merchant.dto.request;

import com.codingShuttle.razorpay_clone.common.Enum.BusinessType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MerchantSignUpRequest(
        @NotNull(message = "Name is required.")
        @Size(min = 3 , max = 20 , message = "Name should be between 3 to 20 characters. ")
        String name,

        @Email
        @NotNull(message = "Email is required.")
        String email,

        @Email
        @Size(min = 8, message = "Password should be atleast 8 characters long.")
        @NotNull(message = "Password is required.")
        String password,

        @Size(max = 20,message = "Business name should be atmost 20 characters")
        String businessName,

        BusinessType businessType
) {
}