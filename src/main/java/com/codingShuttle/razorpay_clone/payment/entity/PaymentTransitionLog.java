package com.codingShuttle.razorpay_clone.payment.entity;


import com.codingShuttle.razorpay_clone.common.Enum.PaymentActor;
import com.codingShuttle.razorpay_clone.common.Enum.PaymentEvent;
import com.codingShuttle.razorpay_clone.common.Enum.PaymentStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payment_transition_logs")
public class PaymentTransitionLog {

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "payment_id",nullable = false)
    private Payment payment;

    @Column(nullable = false)
    private UUID merchantId;

    @Enumerated(EnumType.STRING)
    @Column(name = "from_status",length = 50)
    private PaymentStatus fromStatus;

    @Column(name = "to_status",length = 50)
    @Enumerated(EnumType.STRING)
    private PaymentStatus toStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 20,name = "event")
    private PaymentEvent event;

    @Enumerated(EnumType.STRING)
    private PaymentActor actor;

    private LocalDateTime occuredAt;
}
