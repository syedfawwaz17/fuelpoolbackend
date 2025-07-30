package com.fuelpool.backend.repository;

import com.fuelpool.backend.entity.Payment;
import com.fuelpool.backend.entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PaymentRepository extends MongoRepository<Payment, String> {
    List<Payment> findByBooking(Booking booking);
    List<Payment> findByStatus(String status);
}
