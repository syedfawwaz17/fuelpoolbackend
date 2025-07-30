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
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RideService {
    private final RideRepository rideRepo;
    private final UserRepository userRepo;
    private final CarRepository carRepo;
    private final RideMapper rideMapper;

    public RideDto create(RideDto dto) {
        Ride ride = rideMapper.toEntity(dto);
        ride.setDriver(userRepo.findById(dto.getDriverId()).orElseThrow());
        ride.setCar(carRepo.findById(dto.getCarId()).orElseThrow());
        ride.setStatus("open");
        ride.setCreatedAt(Instant.now());
        ride.setUpdatedAt(Instant.now());
        return rideMapper.toDto(rideRepo.save(ride));
    }

    public RideDto getById(String id) {
        return rideMapper.toDto(rideRepo.findById(id).orElseThrow(() -> new RuntimeException("Ride not found")));
    }

    public List<RideDto> getAllOpen() {
        return rideRepo.findByStatus("open").stream().map(rideMapper::toDto).collect(Collectors.toList());
    }

    public RideDto updateStatus(String id, String status) {
        Ride ride = rideRepo.findById(id).orElseThrow();
        ride.setStatus(status);
        ride.setUpdatedAt(Instant.now());
        return rideMapper.toDto(rideRepo.save(ride));
    }

    public void delete(String id) {
        rideRepo.deleteById(id);
    }
}
