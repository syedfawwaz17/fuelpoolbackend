package com.fuelpool.backend.dto;

import lombok.*;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private String id;
    private String ownerId;                    // User ID reference
    private String model;
    private String registrationNumber;
    private String fuelType;
    private Double mileageKmpl;
    private List<String> mileageProof;        // URLs
    private Integer seatingCapacity;
    private Integer year;
    private FeaturesDto features;
    private List<String> photos;
    private Instant createdAt;
    private Instant updatedAt;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FeaturesDto {
        private Boolean ac;
        private Boolean ladiesOnly;
    }
}
