package com.fuelpool.backend.mapper;

import com.fuelpool.backend.dto.RideDto;
import com.fuelpool.backend.entity.Ride;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RideMapper {
    RideDto toDto(Ride entity);
    Ride toEntity(RideDto dto);
}
