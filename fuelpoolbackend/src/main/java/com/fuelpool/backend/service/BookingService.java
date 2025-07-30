package com.fuelpool.backend.service;

import com.fuelpool.backend.dto.BookingDto;
import com.fuelpool.backend.entity.Booking;
import com.fuelpool.backend.entity.Ride;
import com.fuelpool.backend.entity.User;
import com.fuelpool.backend.mapper.BookingMapper;
import com.fuelpool.backend.repository.BookingRepository;
import com.fuelpool.backend.repository.RideRepository;
import com.fuelpool.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepo;
    private final RideRepository rideRepo;
    private final UserRepository userRepo;
    private final BookingMapper bookingMapper;

    public BookingDto create(BookingDto dto) {
        Booking booking = bookingMapper.toEntity(dto);
        booking.setRide(rideRepo.findById(dto.getRideId()).orElseThrow());
        booking.setRider(userRepo.findById(dto.getRiderId()).orElseThrow());
        booking.setStatus("pending");
        booking.setRequestedAt(Instant.now());
        return bookingMapper.toDto(bookingRepo.save(booking));
    }

    public BookingDto getById(String id) {
        return bookingMapper.toDto(bookingRepo.findById(id).orElseThrow(() -> new RuntimeException("Booking not found")));
    }

    public List<BookingDto> getByRider(String riderId) {
        User rider = userRepo.findById(riderId).orElseThrow();
        return bookingRepo.findByRider(rider).stream().map(bookingMapper::toDto).collect(Collectors.toList());
    }

    public void delete(String id) {
        bookingRepo.deleteById(id);
    }
}
