package com.fuelpool.backend.service;

import com.fuelpool.backend.dto.RideDto;
import com.fuelpool.backend.entity.Car;
import com.fuelpool.backend.entity.Ride;
import com.fuelpool.backend.entity.User;
import com.fuelpool.backend.mapper.RideMapper;
import com.fuelpool.backend.repository.CarRepository;
import com.fuelpool.backend.repository.RideRepository;
import com.fuelpool.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RideService {
    private final RideRepository rideRepo;
    private final UserRepository userRepo;
    private final CarRepository carRepo;
    private final RideMapper rideMapper;

    public RideDto create(RideDto dto) {
        Ride ride = rideMapper.toEntity(dto);

        // Set driver
        User driver = userRepo.findById(dto.getDriverId())
                .orElseThrow(() -> new RuntimeException("Driver not found with ID: " + dto.getDriverId()));
        ride.setDriver(driver);  // Changed from setDriverId to setDriver

        // Set car
        Car car = carRepo.findById(dto.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found with ID: " + dto.getCarId()));
        ride.setCar(car);

        // Set riders
        if (dto.getRiders() != null && !dto.getRiders().isEmpty()) {
            List<User> riders = userRepo.findAllById(dto.getRiders());
            ride.setRiders(riders);
        } else {
            ride.setRiders(new ArrayList<>());
        }

        // Set default values
        ride.setStatus("open");
        ride.setCreatedAt(Instant.now());
        ride.setUpdatedAt(Instant.now());

        Ride saved = rideRepo.save(ride);
        return rideMapper.toDto(saved);
    }

    public RideDto getById(String id) {
        Ride ride = rideRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ride not found with ID: " + id));
        return rideMapper.toDto(ride);
    }

    public List<RideDto> getAllOpen() {
        List<Ride> rides = rideRepo.findByStatus("open");
        if (rides == null) {
            rides = new ArrayList<>();
        }
        try {
            return rides.stream()
                    .map(rideMapper::toDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error mapping open rides", e);
            throw e;
        }
    }

    public RideDto updateStatus(String id, String status) {
        Ride ride = rideRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ride not found with ID: " + id));
        ride.setStatus(status);
        ride.setUpdatedAt(Instant.now());
        Ride updated = rideRepo.save(ride);
        return rideMapper.toDto(updated);
    }

    public void delete(String id) {
        rideRepo.deleteById(id);
    }
}