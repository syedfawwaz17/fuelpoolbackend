package com.fuelpool.backend.mapper;

import com.fuelpool.backend.dto.CarDto;
import com.fuelpool.backend.entity.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarDto toDto(Car entity);
    Car toEntity(CarDto dto);
}
