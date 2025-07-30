package com.fuelpool.backend.service;

import com.fuelpool.backend.dto.ReviewDto;
import com.fuelpool.backend.entity.Review;
import com.fuelpool.backend.entity.Ride;
import com.fuelpool.backend.entity.User;
import com.fuelpool.backend.mapper.ReviewMapper;
import com.fuelpool.backend.repository.ReviewRepository;
import com.fuelpool.backend.repository.RideRepository;
import com.fuelpool.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepo;
    private final UserRepository userRepo;
    private final RideRepository rideRepo;
    private final ReviewMapper reviewMapper;

    public ReviewDto add(ReviewDto dto) {
        Review review = reviewMapper.toEntity(dto);
        review.setReviewer(userRepo.findById(dto.getReviewerId()).orElseThrow());
        review.setReviewee(userRepo.findById(dto.getRevieweeId()).orElseThrow());
        if (dto.getRideId() != null) {
            review.setRide(rideRepo.findById(dto.getRideId()).orElse(null));
        }
        review.setTimestamp(Instant.now());
        return reviewMapper.toDto(reviewRepo.save(review));
    }

    public List<ReviewDto> getByReviewee(String userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return reviewRepo.findByReviewee(user)
                .stream().map(reviewMapper::toDto).collect(Collectors.toList());
    }

    public List<ReviewDto> getByRide(String rideId) {
        Ride ride = rideRepo.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride not found"));
        return reviewRepo.findByRide(ride)
                .stream()
                .map(reviewMapper::toDto)
                .collect(Collectors.toList());
    }

    public void delete(String id) {
        reviewRepo.deleteById(id);
    }
}
