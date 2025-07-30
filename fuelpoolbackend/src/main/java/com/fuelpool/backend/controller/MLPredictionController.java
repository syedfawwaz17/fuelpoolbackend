package com.fuelpool.backend.controller;

import com.fuelpool.backend.dto.MLPredictionLogDto;
import com.fuelpool.backend.service.MLPredictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ml-predictions")
@RequiredArgsConstructor
public class MLPredictionController {

    private final MLPredictionService mlPredictionService;

    @PostMapping("/log")
    public ResponseEntity<MLPredictionLogDto> logPrediction(@RequestBody MLPredictionLogDto dto) {
        MLPredictionLogDto saved = mlPredictionService.logPrediction(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
