package com.example.javabackendtheoryspringboot.lesson30.homework;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
public class RideService {

    private final Set<Long> existingPassengerIds = Set.of(1L, 2L, 3L);

    public RideResponseDto bookRide(RideRequestDto requestDto) {
        if (!existingPassengerIds.contains(requestDto.getPassengerId())) {
            throw new PassengerNotFoundException(
                    "Passenger with ID " + requestDto.getPassengerId() + " was not found."
            );
        }

        return new RideResponseDto(
                "Ride booking accepted.",
                requestDto.getPassengerId(),
                requestDto.getPickupLocation(),
                requestDto.getDropoffLocation(),
                requestDto.getPassengerCount(),
                LocalDateTime.now()
        );
    }
}
