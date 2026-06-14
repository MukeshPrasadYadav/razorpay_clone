package com.codingShuttle.razorpay_clone.Vault;

import com.codingShuttle.razorpay_clone.merchant.entity.Customer;
import com.codingShuttle.razorpay_clone.merchant.entity.Merchant;
import jakarta.persistence.*;
import org.hibernate.sql.results.spi.LoadContexts;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "card_tokens")
public class CardToken {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @Column(nullable = false,unique = true,length = 50)

    private String token;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "vault_card_id",nullable = false)
    private VaultCard vaultCard;

    @Column(nullable = false)
    private  UUID customer;

    @Column(nullable = false)
    private UUID merchant;

    private LocalDateTime revokedAt;
}
