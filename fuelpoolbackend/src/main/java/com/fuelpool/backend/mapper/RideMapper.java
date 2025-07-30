package com.fuelpool.backend.mapper;

import com.fuelpool.backend.dto.RideDto;
import com.fuelpool.backend.entity.Ride;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RideMapper {

    @Mapping(target = "driverId", expression = "java(entity.getDriver().getId())")
    @Mapping(target = "carId", expression = "java(entity.getCar().getId())")
    @Mapping(target = "riderIds", expression = "java(entity.getRiderIds().stream().map(User::getId).collect(Collectors.toList()))")
    RideDto toDto(Ride entity);

    @Mapping(target = "driver", ignore = true)
    @Mapping(target = "car", ignore = true)
    @Mapping(target = "riderIds", ignore = true)
    Ride toEntity(RideDto dto);
}


