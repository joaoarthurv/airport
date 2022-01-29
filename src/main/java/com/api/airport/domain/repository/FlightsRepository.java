package com.api.airport.domain.repository;

import com.api.airport.domain.entity.FlightEntity;

import java.util.List;

public interface FlightsRepository {
    FlightEntity findFlightById(String id);

    List<FlightEntity> getAllFlights();

    void createFlight(FlightEntity flightEntity);

    void deleteFlight(FlightEntity flightEntity);

    void updateFlight(FlightEntity flightEntity);
}
