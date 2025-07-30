package com.fuelpool.backend.dto;

import lombok.*;
import java.time.Instant;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MLPredictionLogDto {
    private String id;
    private Map<String, Object> inputFeatures;
    private Double predictedTotalCost;
    private Double farePerPerson;
    private String modelVersion;
    private Instant timestamp;
}
