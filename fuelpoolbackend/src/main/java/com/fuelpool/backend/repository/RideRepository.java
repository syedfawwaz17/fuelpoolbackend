package com.fuelpool.backend.repository;

import com.fuelpool.backend.entity.Ride;
import com.fuelpool.backend.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.Instant;
import java.util.List;

public interface RideRepository extends MongoRepository<Ride, String> {
    List<Ride> findByDriver(User driver);
    List<Ride> findByStatus(String status);
    List<Ride> findByLadiesOnly(Boolean ladiesOnly);
    List<Ride> findByFuelType(String fuelType);
    List<Ride> findByDepartureTimeAfter(Instant departureTime);
}
