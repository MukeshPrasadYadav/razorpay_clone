package com.codingShuttle.razorpay_clone.Vault;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "vault_card")
public class VaultCard {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false,length = 4)
    private String lastFour;

    @Column(nullable = false, length = 6)
    private String bin;

    @Column(nullable = false)
    private byte [] encryptedPAN;

    @Column(nullable = false)
    private byte[] encryptedDEK;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false,length = 2)
    private String expiryMonth;

    @Column(nullable = false)
    private String expiryYear;

    @Column(nullable = false,length = 100)

    private String cardHolderName;

    private LocalDateTime deletedAt;
 }
