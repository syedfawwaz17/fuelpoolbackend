package com.fuelpool.backend.repository;

import com.fuelpool.backend.entity.Booking;
import com.fuelpool.backend.entity.Ride;
import com.fuelpool.backend.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {
    List<Booking> findByRider(User rider);
    List<Booking> findByRide(Ride ride);
    List<Booking> findByStatus(String status);
}
