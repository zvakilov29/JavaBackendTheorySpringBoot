package com.example.javabackendtheoryspringboot.lesson30.homework;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Ride Booking", description = "API for booking taxi rides")
public class RideController {

    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @Operation(
            summary = "Create a ride booking",
            description = "Accepts pickup and dropoff locations, passenger count, and passenger ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Ride booking accepted",
                            content = @Content(
                                    schema = @Schema(implementation = RideResponseDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Validation error",
                            content = @Content(
                                    examples = @ExampleObject(
                                            value = """
                                                    {
                                                      "pickupLocation": "Pickup location cannot be blank",
                                                      "passengerCount": "Passenger count cannot be more than 4"
                                                    }
                                                    """
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Passenger not found",
                            content = @Content(
                                    schema = @Schema(implementation = ApiErrorResponse.class)
                            )
                    )
            }
    )
    @PostMapping("/api/rides")
    @ResponseStatus(HttpStatus.CREATED)
    public RideResponseDto createRide(@Valid @RequestBody RideRequestDto requestDto) {
        return rideService.bookRide(requestDto);
    }
}
