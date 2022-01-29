package com.api.airport.application.service;

import com.api.airport.domain.dto.FlightDTO;
import com.api.airport.domain.entity.FlightEntity;
import com.api.airport.domain.repository.FlightsRepository;
import com.api.airport.infrastructure.exception.AirportException;
import com.api.airport.infrastructure.exception.ErrorCodeDescription;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FlightService {
    protected final FlightsRepository flightsRepository;

    public FlightService(FlightsRepository flightsRepository) {
        this.flightsRepository = flightsRepository;
    }

    public FlightDTO getFlightById(String id) {
        try {
            FlightEntity flightEntity = flightsRepository.findFlightById(id);
            return createFlightDTO(flightEntity);
        } catch (Exception e) {
            log.error("[FlightService] - Not found flight to id: {}", id);
            throw new AirportException(ErrorCodeDescription.NOT_FOUND_FLIGHT);
        }
    }

    public List<FlightDTO> getAllFlights() {
        try {
            List<FlightEntity> flightEntityList = flightsRepository.getAllFlights();
            return convertToFlightDTOList(flightEntityList);
        } catch (Exception e) {
            log.error("[FlightService] - Not found flights register");
            throw new AirportException(ErrorCodeDescription.NOT_FOUND_FLIGHT);
        }
    }

    private List<FlightDTO> convertToFlightDTOList(List<FlightEntity> flightEntityList) {
        List<FlightDTO> flightDTOList = new ArrayList<>();
        flightEntityList.forEach(flight -> flightDTOList.add(createFlightDTO(flight)));
        return flightDTOList;
    }

    private FlightDTO createFlightDTO(FlightEntity flightEntity) {
        return new FlightDTO(
                flightEntity.getId(),
                flightEntity.getBoardingGate(),
                flightEntity.getFlightTakeOffDate(),
                flightEntity.getFlightLandingDate(),
                flightEntity.getNumberSeats(),
                flightEntity.getTakeOffAirport(),
                flightEntity.getLandingAirport()
        );
    }
}
