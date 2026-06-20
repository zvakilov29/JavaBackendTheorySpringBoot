package com.example.javabackendtheoryspringboot.lesson30.homework;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "Request body for creating a ride booking")
public class RideRequestDto {

    @Schema(description = "Passenger ID", example = "1")
    @NotNull(message = "Passenger ID is required")
    @Positive(message = "Passenger ID must be positive")
    private Long passengerId;

    @Schema(description = "Pickup location address", example = "28 May metro station")
    @NotBlank(message = "Pickup location cannot be blank")
    private String pickupLocation;

    @Schema(description = "Dropoff location address", example = "Heydar Aliyev Airport")
    @NotBlank(message = "Dropoff location cannot be blank")
    private String dropoffLocation;

    @Schema(description = "Number of passengers", example = "2")
    @Min(value = 1, message = "Passenger count must be at least 1")
    @Max(value = 4, message = "Passenger count cannot be more than 4")
    private int passengerCount;

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }
}
