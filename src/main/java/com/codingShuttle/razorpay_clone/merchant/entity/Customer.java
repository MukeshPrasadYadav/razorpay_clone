package com.codingShuttle.razorpay_clone.merchant.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name ="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false,length = 20)
    private String email;

    @Column(length = 15)
    private String contactNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;

    private LocalDateTime deletedAt;
}
