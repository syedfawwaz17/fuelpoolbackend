package com.fuelpool.backend.mapper;

import com.fuelpool.backend.dto.RideDto;
import com.fuelpool.backend.entity.Ride;
import com.fuelpool.backend.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {User.class, Collectors.class})
public interface RideMapper {

    @Mapping(target = "driverId", expression = "java(entity.getDriver() != null ? entity.getDriver().getId() : null)")
    @Mapping(target = "carId", expression = "java(entity.getCar() != null ? entity.getCar().getId() : null)")
    @Mapping(target = "riders", expression = "java(entity.getRiders() != null ? entity.getRiders().stream().map(User::getId).collect(Collectors.toList()) : null)")
    RideDto toDto(Ride entity);

    @Mapping(target = "driver", ignore = true)
    @Mapping(target = "car", ignore = true)
    @Mapping(target = "riders", ignore = true)
    Ride toEntity(RideDto dto);

    // Optionally default mapping methods as needed...
}
