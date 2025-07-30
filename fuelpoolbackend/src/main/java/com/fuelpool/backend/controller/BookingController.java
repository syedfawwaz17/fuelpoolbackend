package com.fuelpool.backend.controller;

import com.fuelpool.backend.dto.BookingDto;
import com.fuelpool.backend.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto) {
        BookingDto created = bookingService.create(bookingDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> getBooking(@PathVariable String id) {
        BookingDto booking = bookingService.getById(id);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/rider/{riderId}")
    public ResponseEntity<List<BookingDto>> getBookingsByRider(@PathVariable String riderId) {
        List<BookingDto> bookings = bookingService.getByRider(riderId);
        return ResponseEntity.ok(bookings);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable String id) {
        bookingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
