package com.fuelpool.backend.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "payments")
public class Payment {

    @Id
    private String id;

    @DBRef
    private Booking booking;

    private Double amount;
    private String status; // "initiated", "completed", "failed"
    private String method; // UPI, wallet, card, etc.
    private Instant timestamp;
}
