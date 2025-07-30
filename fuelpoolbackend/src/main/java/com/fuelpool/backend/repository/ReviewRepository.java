package com.fuelpool.backend.repository;

import com.fuelpool.backend.entity.Review;
import com.fuelpool.backend.entity.User;
import com.fuelpool.backend.entity.Ride;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findByReviewer(User reviewer);
    List<Review> findByReviewee(User reviewee);
    List<Review> findByRide(Ride ride);
}
