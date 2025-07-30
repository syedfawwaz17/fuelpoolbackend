package com.fuelpool.backend.repository;

import com.fuelpool.backend.entity.FuelPriceRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.Instant;
import java.util.List;

public interface FuelPriceRecordRepository extends MongoRepository<FuelPriceRecord, String> {
    List<FuelPriceRecord> findByCityAndFuelTypeOrderByTimestampDesc(String city, String fuelType);
    List<FuelPriceRecord> findByTimestampAfter(Instant timestamp);
}
