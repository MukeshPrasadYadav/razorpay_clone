package com.codingShuttle.razorpay_clone.merchant.entity;

import com.codingShuttle.razorpay_clone.common.Entity.BaseEntity;
import com.codingShuttle.razorpay_clone.common.Enum.Environment;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "api_key")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiKey extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;

    @Column(nullable = false,length = 20)
    private String keyId;

    @Column(nullable = false,length = 64)
    private String keyHash;

    private Environment environment;

    @Column(nullable = false)
    @Builder.Default
    private boolean enabled  = true;

    private LocalDateTime lastUpdatedAt;

    private LocalDateTime rotatedAt;

    private LocalDateTime graceNoticePeriod;
}
