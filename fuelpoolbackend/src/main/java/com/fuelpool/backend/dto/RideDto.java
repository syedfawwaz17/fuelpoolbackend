package com.fuelpool.backend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RideDto {

    private String id;

    @NotNull(message = "Driver ID is required")
    private String driverId;

    @NotNull(message = "Car ID is required")
    private String carId;

    @NotNull(message = "Pickup location must be specified")
    private LocationDto pickupLocation;

    @NotNull(message = "Destination location must be specified")
    private LocationDto destination;

    @NotNull(message = "Departure time is required")
    private Instant departureTime;

    private Boolean ladiesOnly;

    private String fuelType;

    private Integer availableSeats;

    private Double farePerSeat;

    private String status; // "open", "booked", etc.

    private List<String> riders;

    private Instant createdAt;
    private Instant updatedAt;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LocationDto {
        private String address;

        @Size(min = 2, max = 2, message = "Coordinates must have exactly 2 elements [longitude, latitude]")
        private double[] coordinates;
    }
}
