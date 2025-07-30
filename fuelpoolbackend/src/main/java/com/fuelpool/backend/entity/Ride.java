package com.fuelpool.backend.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "rides")
public class Ride {

    @Id
    private String id;

    @DBRef
    private User driver;  // Changed from 'driverId' to 'driver'

    @DBRef
    private Car car;

    private Location pickupLocation;
    private Location destination;

    private Instant departureTime;
    private Boolean ladiesOnly;
    private String fuelType; // "petrol" or "diesel"
    private Integer availableSeats;
    private Double farePerSeat;
    private String status; // "open", "booked", "in_progress", "completed", "cancelled"

    @DBRef
    private List<User> riders;

    private Instant createdAt;
    private Instant updatedAt;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Location {
        private String address;
        @Field("coordinates")
        private double[] coordinates; // GeoJSON format: [longitude, latitude]
    }
}