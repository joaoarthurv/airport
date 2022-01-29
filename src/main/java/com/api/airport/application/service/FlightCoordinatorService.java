package com.api.airport.application.service;

import com.api.airport.domain.dto.FlightDTO;
import com.api.airport.domain.entity.FlightEntity;
import com.api.airport.domain.repository.FlightsRepository;
import com.api.airport.infrastructure.exception.AirportException;
import com.api.airport.infrastructure.exception.ErrorCodeDescription;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FlightCoordinatorService extends FlightService {
    public FlightCoordinatorService(FlightsRepository flightsRepository) {
        super(flightsRepository);
    }

    public void createFlight(FlightDTO flightDTO) {
        flightsRepository.createFlight(convertToFlightEntity(flightDTO));
    }

    private FlightEntity convertToFlightEntity(FlightDTO flightDTO) {
        return new FlightEntity(
                flightDTO.getBoardingGate(),
                flightDTO.getFlightTakeOffDate(),
                flightDTO.getFlightLandingDate(),
                flightDTO.getNumberSeats(),
                flightDTO.getTakeOffAirport(),
                flightDTO.getLandingAirport());
    }

    public void deleteFlight(String id) {
        try {
            var flightEntity = flightsRepository.findFlightById(id);
            flightsRepository.deleteFlight(flightEntity);
        } catch (Exception e) {
            log.error("[FlightCoordinatorService] - Bad request for delete flight to id: {}", id);
            throw new AirportException(ErrorCodeDescription.BAD_REQUEST_FOR_DELETE_FLIGHT);
        }
    }

    public void updateFlight(String id, FlightDTO flightDTO) {
        try {
            var response = flightsRepository.findFlightById(id);
            var toUpdate = convertToFlightEntity(flightDTO);
            toUpdate.setId(response.getId());
            flightsRepository.updateFlight(toUpdate);
        } catch (Exception e) {
            log.error("[FlightCoordinatorService] - Bad request for update flight to id: {}", id);
            throw new AirportException(ErrorCodeDescription.BAD_REQUEST_FOR_UPDATE_FLIGHT);
        }
    }

}
