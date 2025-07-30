package com.fuelpool.backend.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String name;
    private String email;

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String passwordHash;  // hashed password stored safely
    private String phone;
    private String gender; // "male", "female", "other"
    private Boolean verified;
    private String profilePhotoUrl;
    private String userType; // "driver", "rider", "admin"
    private String password;

    private Preferences preferences;

    private Ratings ratings;

    private List<String> reviews; // List of Review IDs

    private Instant createdAt;
    private Instant updatedAt;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Preferences {
        private Boolean ladiesOnly;         // whether user opts for ladies-only rides
        private String fuelPreference;      // "petrol", "diesel", or "any"
        private Boolean allowStrangers;     // whether user allows strangers in carpool
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Ratings {
        private Double average;
        private Integer count;
    }
}
