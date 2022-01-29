package com.api.airport.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;


@Data
@AllArgsConstructor
public class FlightDTO {
    private String id;
    @NonNull
    private String boardingGate;
    @NonNull
    private Date flightTakeOffDate;
    @NonNull
    private Date flightLandingDate;
    @NonNull
    private Long numberSeats;
    @NonNull
    private String takeOffAirport;
    @NonNull
    private String landingAirport;
}
