package com.fuelpool.backend.mapper;

import com.fuelpool.backend.dto.ReviewDto;
import com.fuelpool.backend.entity.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewDto toDto(Review entity);
    Review toEntity(ReviewDto dto);
}
