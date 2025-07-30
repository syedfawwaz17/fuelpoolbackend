package com.fuelpool.backend.service;

import com.fuelpool.backend.dto.CarDto;
import com.fuelpool.backend.entity.Car;
import com.fuelpool.backend.entity.User;
import com.fuelpool.backend.mapper.CarMapper;
import com.fuelpool.backend.repository.CarRepository;
import com.fuelpool.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepo;
    private final UserRepository userRepo;
    private final CarMapper carMapper;

    public CarDto create(CarDto dto) {
        Car car = carMapper.toEntity(dto);
        car.setOwner(userRepo.findById(dto.getOwnerId()).orElseThrow());
        car.setCreatedAt(Instant.now());
        car.setUpdatedAt(Instant.now());
        return carMapper.toDto(carRepo.save(car));
    }

    public CarDto getById(String id) {
        return carMapper.toDto(carRepo.findById(id).orElseThrow(() -> new RuntimeException("Car not found")));
    }

    public List<CarDto> getByOwner(String ownerId) {
        User owner = userRepo.findById(ownerId).orElseThrow();
        return carRepo.findByOwner(owner).stream().map(carMapper::toDto).collect(Collectors.toList());
    }

    public CarDto update(String id, CarDto dto) {
        Car car = carRepo.findById(id).orElseThrow();
        // Update only allowed fields as needed
        car.setModel(dto.getModel());
        car.setSeatingCapacity(dto.getSeatingCapacity());
        car.setUpdatedAt(Instant.now());
        return carMapper.toDto(carRepo.save(car));
    }

    public void delete(String id) {
        carRepo.deleteById(id);
    }
}
