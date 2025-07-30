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
@Document(collection = "bookings")
public class Booking {

    @Id
    private String id;

    @DBRef
    private Ride ride;

    @DBRef
    private User rider;

    private String status; // "pending", "confirmed", "cancelled"
    private Double farePaid;

    private Instant requestedAt;
    private Instant confirmedAt;
    private Instant cancelledAt;
}
