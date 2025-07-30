package com.fuelpool.backend.repository;

import com.fuelpool.backend.entity.MLPredictionLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MLPredictionLogRepository extends MongoRepository<MLPredictionLog, String> {
    List<MLPredictionLog> findByModelVersion(String modelVersion);
}
