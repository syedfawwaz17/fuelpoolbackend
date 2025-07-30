package com.fuelpool.backend.service;

import com.fuelpool.backend.dto.UserDto;
import com.fuelpool.backend.entity.User;
import com.fuelpool.backend.mapper.UserMapper;
import com.fuelpool.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    /**
     * Registers a new user.
     * Encodes the plain-text password from DTO and saves passwordHash in entity.
     */
    public UserDto register(UserDto dto) {
        User user = userMapper.toEntity(dto);
        if (dto.getPassword() == null || dto.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        user.setPasswordHash(passwordEncoder.encode(dto.getPassword())); // encode plain password
        user.setCreatedAt(Instant.now());
        user.setUpdatedAt(Instant.now());
        user.setVerified(false);
        return userMapper.toDto(userRepository.save(user));
    }

    public UserDto getById(String id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDto update(String id, UserDto dto) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (dto.getName() != null) existing.setName(dto.getName());
        if (dto.getPhone() != null) existing.setPhone(dto.getPhone());
        if (dto.getGender() != null) existing.setGender(dto.getGender());
        if (dto.getProfilePhotoUrl() != null) existing.setProfilePhotoUrl(dto.getProfilePhotoUrl());
        if (dto.getUserType() != null) existing.setUserType(dto.getUserType());

        if (dto.getPreferences() != null) {
            existing.setPreferences(userMapper.preferencesDtoToEntity(dto.getPreferences()));
        }
        if (dto.getRatings() != null) {
            existing.setRatings(userMapper.ratingsDtoToEntity(dto.getRatings()));
        }

        existing.setUpdatedAt(Instant.now());

        return userMapper.toDto(userRepository.save(existing));
    }


    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public UserDto findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toDto)
                .orElse(null);
    }

    // Add more user-related methods as needed, e.g., password reset, verification status update, etc.
}
