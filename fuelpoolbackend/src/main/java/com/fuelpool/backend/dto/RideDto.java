package com.fuelpool.backend.dto;

import lombok.*;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RideDto {
    private String id;
    private String driverId;                   // User ID
    private String carId;                      // Car ID

    private LocationDto pickupLocation;
    private LocationDto destination;

    private Instant departureTime;
    private Boolean ladiesOnly;
    private String fuelType;
    private Integer availableSeats;
    private Double farePerSeat;
    private String status;                     // open, booked,...

    private List<String> riderIds;             // List of User IDs who booked

    private Instant createdAt;
    private Instant updatedAt;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LocationDto {
        private String address;
        private double[] coordinates; // [longitude, latitude]
    }
}
