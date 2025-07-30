package com.fuelpool.backend.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "ml_prediction_logs")
public class MLPredictionLog {

    @Id
    private String id;

    private Map<String, Object> inputFeatures; // JSON key-value of input features

    private Double predictedTotalCost;
    private Double farePerPerson;

    private String modelVersion; // e.g., "v1.0"

    private Instant timestamp;
}
