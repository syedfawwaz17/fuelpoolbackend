package com.fuelpool.backend.mapper;

import com.fuelpool.backend.dto.BookingDto;
import com.fuelpool.backend.entity.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingDto toDto(Booking entity);
    Booking toEntity(BookingDto dto);
}
