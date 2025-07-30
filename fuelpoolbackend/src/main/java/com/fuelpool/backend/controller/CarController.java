package com.fuelpool.backend.controller;

import com.fuelpool.backend.dto.CarDto;
import com.fuelpool.backend.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping
    public ResponseEntity<CarDto> createCar(@RequestBody CarDto carDto) {
        CarDto created = carService.create(carDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCar(@PathVariable String id) {
        CarDto carDto = carService.getById(id);
        return ResponseEntity.ok(carDto);
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<CarDto>> getCarsByOwner(@PathVariable String ownerId) {
        List<CarDto> cars = carService.getByOwner(ownerId);
        return ResponseEntity.ok(cars);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable String id, @RequestBody CarDto carDto) {
        CarDto updated = carService.update(id, carDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable String id) {
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
