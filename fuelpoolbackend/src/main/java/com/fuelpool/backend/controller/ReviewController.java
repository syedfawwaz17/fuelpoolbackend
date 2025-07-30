package com.fuelpool.backend.controller;

import com.fuelpool.backend.dto.ReviewDto;
import com.fuelpool.backend.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewDto> addReview(@RequestBody ReviewDto dto) {
        ReviewDto saved = reviewService.add(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReviewDto>> getReviewsByUser(@PathVariable String userId) {
        List<ReviewDto> reviews = reviewService.getByReviewee(userId);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/ride/{rideId}")
    public ResponseEntity<List<ReviewDto>> getReviewsByRide(@PathVariable String rideId) {
        List<ReviewDto> reviews = reviewService.getByRide(rideId);
        return ResponseEntity.ok(reviews);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable String id) {
        reviewService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
