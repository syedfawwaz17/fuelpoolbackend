package com.fuelpool.backend.dto;

import lombok.*;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
        private String id;
        private String bookingId;                 // Booking reference ID
        private Double amount;
        private String status;
        private String method;
        private Instant timestamp;
}
