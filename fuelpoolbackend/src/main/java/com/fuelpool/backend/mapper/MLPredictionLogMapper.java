package com.fuelpool.backend.mapper;

import com.fuelpool.backend.dto.MLPredictionLogDto;
import com.fuelpool.backend.entity.MLPredictionLog;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MLPredictionLogMapper {
    MLPredictionLogDto toDto(MLPredictionLog entity);
    MLPredictionLog toEntity(MLPredictionLogDto dto);
}
