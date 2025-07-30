package com.fuelpool.backend.controller;

import com.fuelpool.backend.dto.PaymentDto;
import com.fuelpool.backend.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentDto> createPayment(@RequestBody PaymentDto dto) {
        PaymentDto created = paymentService.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> getPayment(@PathVariable String id) {
        PaymentDto payment = paymentService.getById(id);
        return ResponseEntity.ok(payment);
    }
}
