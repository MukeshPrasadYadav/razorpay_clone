package com.codingShuttle.razorpay_clone.merchant.entity;


import com.codingShuttle.razorpay_clone.common.Entity.BaseEntity;
import com.codingShuttle.razorpay_clone.common.Enum.BusinessType;
import com.codingShuttle.razorpay_clone.common.Enum.MerchantStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "merchant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Merchant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(length = 20)
    private String contactNumber;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

    @Column(length = 100)
    private String businessName;

    @Column(length = 200)
    private String busniessWebsiteUrl;

    @Column(length = 20,nullable = false)
    @Enumerated(EnumType.STRING)
    private MerchantStatus status = MerchantStatus.PENDING_KYC;

    @Column(length = 20)
    private String getId;

    @Column(length = 20)
    private String panId;

    @Column(length = 50)
    private String settlementBankAccount;

    @Column(length = 20)
    private String settlementBankIfscCode;

    @Column(length = 50)
    private  String getSettlementBankAccountHolderName;
}
