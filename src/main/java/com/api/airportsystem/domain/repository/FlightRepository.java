package com.api.airportsystem.domain.repository;

import com.api.airportsystem.domain.entity.FlightEntity;

import java.util.List;

public interface FlightRepository {
    FlightEntity findFlightById(String id);

    List<FlightEntity> getAllFlights();

    void createFlight(FlightEntity flightEntity);

    void deleteFlight(FlightEntity flightEntity);

    void updateFlight(FlightEntity flightEntity);
}
