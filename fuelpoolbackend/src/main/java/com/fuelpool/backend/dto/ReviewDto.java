package com.fuelpool.backend.dto;

import lombok.*;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private String id;
    private String reviewerId;             // User ID
    private String revieweeId;
    private String rideId;
    private Integer rating;
    private String reviewText;
    private Instant timestamp;
}
