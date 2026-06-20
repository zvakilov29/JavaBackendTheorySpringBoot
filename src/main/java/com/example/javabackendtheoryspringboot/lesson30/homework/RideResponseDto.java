package com.example.javabackendtheoryspringboot.lesson30.homework;

import java.time.LocalDateTime;

public class RideResponseDto {
    private String message;
    private Long passengerId;
    private String pickupLocation;
    private String dropoffLocation;
    private int passengerCount;
    private LocalDateTime createdAt;

    public RideResponseDto(String message,
                           Long passengerId,
                           String pickupLocation,
                           String dropoffLocation,
                           int passengerCount,
                           LocalDateTime createdAt) {
        this.message = message;
        this.passengerId = passengerId;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.passengerCount = passengerCount;
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
