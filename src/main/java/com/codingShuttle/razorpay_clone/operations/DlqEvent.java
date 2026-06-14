package com.codingShuttle.razorpay_clone.operations;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "dlq_event")
public class DlqEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID merchantId;

    @Column(length = 1000)

    private String finalError;


    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String,Object> payLoad;

    private LocalDateTime movedAt;

    private LocalDateTime replayedAt;

    @OneToOne(fetch = FetchType.LAZY,optional = false)
    private WebhookEvent webhookEvent;
}
