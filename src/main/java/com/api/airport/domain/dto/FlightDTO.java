package com.api.airport.domain.dto;

import java.util.Date;

public record FlightDTO(String id, String boardingGate, Date flightTakeOffDate, Date flightLandingDate,
                        Long numberSeats, String takeOffAirport, String landingAirport) {
}
