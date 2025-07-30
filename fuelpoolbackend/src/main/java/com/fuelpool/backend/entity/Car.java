package com.fuelpool.backend.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "cars")
public class Car {

    @Id
    private String id;

    @DBRef
    private User owner;

    private String model;
    private String registrationNumber;
    private String fuelType; // "petrol" or "diesel"
    private Double mileageKmpl; // verified mileage
    private List<String> mileageProof; // URLs to photos/documents
    private Integer seatingCapacity;
    private Integer year;

    private Features features;

    private List<String> photos;
    private Instant createdAt;
    private Instant updatedAt;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Features {
        private Boolean ac;
        private Boolean ladiesOnly; // if car designated as ladies-only
    }
}
