package com.fuelpool.backend.controller;

import com.fuelpool.backend.dto.RideDto;
import com.fuelpool.backend.service.RideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rides")
@RequiredArgsConstructor
public class RideController {

    private final RideService rideService;

    @PostMapping
    public ResponseEntity<RideDto> createRide(@RequestBody RideDto rideDto) {
        RideDto created = rideService.create(rideDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RideDto> getRide(@PathVariable String id) {
        RideDto ride = rideService.getById(id);
        return ResponseEntity.ok(ride);
    }

    @GetMapping("/open")
    public ResponseEntity<List<RideDto>> getAllOpenRides() {
        List<RideDto> rides = rideService.getAllOpen();
        return ResponseEntity.ok(rides);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<RideDto> updateRideStatus(@PathVariable String id, @RequestParam String status) {
        RideDto updated = rideService.updateStatus(id, status);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRide(@PathVariable String id) {
        rideService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
