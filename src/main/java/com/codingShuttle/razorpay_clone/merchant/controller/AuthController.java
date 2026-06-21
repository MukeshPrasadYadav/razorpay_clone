package com.codingShuttle.razorpay_clone.merchant.controller;


import com.codingShuttle.razorpay_clone.merchant.dto.request.MerchantSignUpRequest;
import com.codingShuttle.razorpay_clone.merchant.dto.response.MerchantSingUpResponse;
import com.codingShuttle.razorpay_clone.merchant.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthService authService;


    @PostMapping("/signup")
    public ResponseEntity<MerchantSingUpResponse> signUp(@RequestBody @Valid MerchantSignUpRequest request){

        return ResponseEntity.status(HttpStatus.CREATED).body(authService.signup(request));


    }

}
