package com.fuelpool.backend.dto;

import lombok.*;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuelPriceRecordDto {
    private String id;
    private String city;
    private String fuelType;
    private Double pricePerLitre;
    private String apiSource;
    private Instant timestamp;
}
