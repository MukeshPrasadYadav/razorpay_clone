package com.codingShuttle.razorpay_clone.operations;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class SettlementPaymentId {

    private UUID paymentId;

    private UUID settlementId;
}
