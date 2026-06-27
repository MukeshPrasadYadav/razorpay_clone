package com.codingShuttle.razorpay_clone.operations;


import com.codingShuttle.razorpay_clone.common.Entity.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "settlement_payment")
public class SettlementPayment extends BaseEntity {

    @EmbeddedId
    private SettlementPaymentId id;


    @MapsId("settlementId")
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "settlement_id",nullable = false)
    private Settlement settlement;
}
