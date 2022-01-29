package com.api.airport.application.service;

import com.api.airport.domain.dto.FlightDTO;
import com.api.airport.domain.mapper.FlightMapper;
import com.api.airport.domain.repository.FlightRepository;
import com.api.airport.infrastructure.exception.AirportException;
import com.api.airport.infrastructure.exception.ErrorCodeDescription;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FlightCoordinatorService extends FlightService {
    public FlightCoordinatorService(FlightRepository flightRepository, FlightMapper flightMapper) {
        super(flightRepository, flightMapper);
    }

    public void createFlight(FlightDTO flightDTO) {
        flightRepository.createFlight(flightMapper.toFlightEntityWithoutId(flightDTO));
    }

    public void deleteFlight(String id) {
        try {
            var flightEntity = flightRepository.findFlightById(id);
            flightRepository.deleteFlight(flightEntity);
        } catch (Exception e) {
            log.error("[FlightCoordinatorService] - Bad request for delete flight to id: {}", id);
            throw new AirportException(ErrorCodeDescription.BAD_REQUEST_FOR_DELETE_FLIGHT);
        }
    }

    public void updateFlight(String id, FlightDTO flightDTO) {
        try {
            var response = flightRepository.findFlightById(id);
            var toUpdate = flightMapper.toFlightEntityWithoutId(flightDTO);
            toUpdate.setId(response.getId());
            flightRepository.updateFlight(toUpdate);
        } catch (Exception e) {
            log.error("[FlightCoordinatorService] - Bad request for update flight to id: {}", id);
            throw new AirportException(ErrorCodeDescription.BAD_REQUEST_FOR_UPDATE_FLIGHT);
        }
    }
}
