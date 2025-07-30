package com.fuelpool.backend.service;

import com.fuelpool.backend.dto.PaymentDto;
import com.fuelpool.backend.entity.Booking;
import com.fuelpool.backend.entity.Payment;
import com.fuelpool.backend.mapper.PaymentMapper;
import com.fuelpool.backend.repository.BookingRepository;
import com.fuelpool.backend.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepo;
    private final BookingRepository bookingRepo;
    private final PaymentMapper paymentMapper;

    public PaymentDto create(PaymentDto dto) {
        Payment payment = paymentMapper.toEntity(dto);
        payment.setBooking(bookingRepo.findById(dto.getBookingId()).orElseThrow());
        payment.setStatus("initiated");
        payment.setTimestamp(java.time.Instant.now());
        return paymentMapper.toDto(paymentRepo.save(payment));
    }

    public PaymentDto getById(String id) {
        return paymentMapper.toDto(paymentRepo.findById(id).orElseThrow(() -> new RuntimeException("Payment not found")));
    }
}
