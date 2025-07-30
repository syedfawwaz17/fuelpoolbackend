package com.fuelpool.backend.mapper;

import com.fuelpool.backend.dto.UserDto;
import com.fuelpool.backend.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Map entity -> DTO, but don't map password (no plain password in entity)
    @Mapping(target = "password", ignore = true)
    // Remove passwordHash field from DTO to avoid conflicts, ensure it's not present there
    UserDto toDto(User entity);

    // Map DTO -> entity, but ignore passwordHash as it's set manually after encoding the plain password
    @Mapping(target = "passwordHash", ignore = true)
    User toEntity(UserDto dto);

    // Mapping for Preferences nested object
    User.Preferences preferencesDtoToEntity(UserDto.PreferencesDto dto);
    UserDto.PreferencesDto preferencesEntityToDto(User.Preferences entity);

    // Mapping for Ratings nested object
    User.Ratings ratingsDtoToEntity(UserDto.RatingsDto dto);
    UserDto.RatingsDto ratingsEntityToDto(User.Ratings entity);
}
