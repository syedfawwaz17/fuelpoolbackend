package com.fuelpool.backend.controller;

import com.fuelpool.backend.dto.FuelPriceRecordDto;
import com.fuelpool.backend.service.FuelPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fuel-prices")
@RequiredArgsConstructor
public class FuelPriceController {

    private final FuelPriceService fuelPriceService;

    @GetMapping("/latest")
    public ResponseEntity<List<FuelPriceRecordDto>> getLatestFuelPrices(@RequestParam String city,
                                                                        @RequestParam String fuelType) {
        List<FuelPriceRecordDto> prices = fuelPriceService.getLatestByCityAndType(city, fuelType);
        return ResponseEntity.ok(prices);
    }

    @PostMapping
    public ResponseEntity<FuelPriceRecordDto> addFuelPrice(@RequestBody FuelPriceRecordDto dto) {
        FuelPriceRecordDto saved = fuelPriceService.add(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
