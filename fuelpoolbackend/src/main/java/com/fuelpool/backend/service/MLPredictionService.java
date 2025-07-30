package com.fuelpool.backend.service;

import com.fuelpool.backend.dto.MLPredictionLogDto;
import com.fuelpool.backend.entity.MLPredictionLog;
import com.fuelpool.backend.mapper.MLPredictionLogMapper;
import com.fuelpool.backend.repository.MLPredictionLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MLPredictionService {
    private final MLPredictionLogRepository logRepo;
    private final MLPredictionLogMapper logMapper;

    public MLPredictionLogDto logPrediction(MLPredictionLogDto dto) {
        MLPredictionLog entity = logMapper.toEntity(dto);
        entity.setTimestamp(java.time.Instant.now());
        return logMapper.toDto(logRepo.save(entity));
    }
}
