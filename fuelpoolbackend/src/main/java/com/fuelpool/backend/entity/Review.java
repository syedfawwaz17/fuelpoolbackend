package com.fuelpool.backend.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "reviews")
public class Review {

    @Id
    private String id;

    @DBRef
    private User reviewer;

    @DBRef
    private User reviewee;

    @DBRef
    private Ride ride;

    private Integer rating; // 1 - 5 stars
    private String reviewText;

    private Instant timestamp;
}
