package com.codingShuttle.razorpay_clone.payment.entity;

import com.codingShuttle.razorpay_clone.common.Entity.BaseEntity;
import com.codingShuttle.razorpay_clone.common.Entity.Money;
import com.codingShuttle.razorpay_clone.common.Enum.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "order_records")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderRecord extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "merchant_id", nullable = false)
    private UUID merchantId;

    @Column(length = 100)
    private String receipt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 20)
    private OrderStatus orderStatus;

    @Embedded
    private Money amount;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> notes;

    @Min(1)
    @Max(8)
    @Builder.Default
    private Integer attempts = 1;

    private LocalDateTime expiresAt;

}
