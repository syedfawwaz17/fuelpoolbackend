package com.fuelpool.backend.mapper;

import com.fuelpool.backend.dto.FuelPriceRecordDto;
import com.fuelpool.backend.entity.FuelPriceRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FuelPriceRecordMapper {
    FuelPriceRecordDto toDto(FuelPriceRecord entity);
    FuelPriceRecord toEntity(FuelPriceRecordDto dto);
}
