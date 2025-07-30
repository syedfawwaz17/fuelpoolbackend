package com.fuelpool.backend.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "fuel_price_records")
public class FuelPriceRecord {

    @Id
    private String id;

    private String city;
    private String fuelType; // "petrol" or "diesel"
    private Double pricePerLitre;
    private String apiSource; // e.g., "Nixinfo", "Zylalabs"
    private Instant timestamp;
}
