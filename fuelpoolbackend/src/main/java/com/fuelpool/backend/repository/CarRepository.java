package com.fuelpool.backend.repository;

import com.fuelpool.backend.entity.Car;
import com.fuelpool.backend.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface CarRepository extends MongoRepository<Car, String> {
    List<Car> findByOwner(User owner);
    List<Car> findByFuelType(String fuelType);
    List<Car> findByFeaturesLadiesOnly(Boolean ladiesOnly);
}
