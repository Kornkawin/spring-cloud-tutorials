package com.amigoscode.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

// In case of old java version, there is no "record" keyword.
// So, we have to use normal "class".
@Service
public class FraudCheckService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    // constructor
    public FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
        this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
    }

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
