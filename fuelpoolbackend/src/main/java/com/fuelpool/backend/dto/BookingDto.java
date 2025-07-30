package com.fuelpool.backend.dto;

import lombok.*;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private String id;
    private String rideId;                    // Ride reference ID
    private String riderId;                   // Rider User ID
    private String status;
    private Double farePaid;
    private Instant requestedAt;
    private Instant confirmedAt;
    private Instant cancelledAt;
}
