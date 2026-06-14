package com.codingShuttle.razorpay_clone.merchant.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "merchant_webhook_config")
public class Merchant_webhook_config {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "merchant_id",nullable = false)
    private Merchant merchant;

    @Column(length = 255)
    private String webhookSecretHash;

    @Column(nullable = false,length = 500)
    private String targetUrl;

    @Column(nullable = false)
    private boolean enable = true;

    private String eventTypes;
}
