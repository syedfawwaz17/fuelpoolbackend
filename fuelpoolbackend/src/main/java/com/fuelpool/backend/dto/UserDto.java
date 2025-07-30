package com.fuelpool.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private Boolean verified;
    private String profilePhotoUrl;
    private String userType;

    private PreferencesDto preferences;
    private RatingsDto ratings;
    private List<String> reviewIds;

    private Instant createdAt;
    private Instant updatedAt;


    private String password;
    private String passwordHash;

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







    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PreferencesDto {
        private Boolean ladiesOnly;
        private String fuelPreference;
        private Boolean allowStrangers;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RatingsDto {
        private Double average;
        private Integer count;
    }
}
