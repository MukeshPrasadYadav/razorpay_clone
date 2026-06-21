package com.codingShuttle.razorpay_clone.merchant.repository;


import com.codingShuttle.razorpay_clone.merchant.entity.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApiKeyRepository extends JpaRepository<ApiKey, UUID> {
}
