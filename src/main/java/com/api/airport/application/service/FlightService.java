package com.api.airport.application.service;

import com.api.airport.domain.dto.FlightDTO;
import com.api.airport.domain.entity.FlightEntity;
import com.api.airport.domain.mapper.FlightMapper;
import com.api.airport.domain.repository.FlightRepository;
import com.api.airport.infrastructure.exception.ErrorCodeDescription;
import com.api.airport.infrastructure.exception.exceptions.AirportException;
import com.api.airport.infrastructure.exception.exceptions.FlightException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FlightService {
    protected final FlightRepository flightRepository;
    protected final FlightMapper flightMapper;

    public FlightService(FlightRepository flightRepository, FlightMapper flightMapper) {
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
    }

    public FlightDTO getFlightById(String id) {
        try {
            var response = flightRepository.findFlightById(id);
            if (response == null) {
                throw new FlightException(ErrorCodeDescription.NOT_FOUND_FLIGHT);
            }
            return flightMapper.toFlightDTO(response);
        } catch (FlightException flightException) {
            log.error("[FlightService] - Not found flight to id: {}", id);
            throw flightException;
        } catch (Exception e) {
            throw new AirportException(ErrorCodeDescription.UNKNOWN_ERROR);
        }
    }

    public List<FlightDTO> getAllFlights() {
        try {
            var response = flightRepository.getAllFlights();
            if (response == null) {
                throw new FlightException(ErrorCodeDescription.NOT_FOUND_FLIGHTS);
            }
            return convertToFlightDTOList(response);
        } catch (FlightException flightException) {
            log.error("[FlightService] - Not found flights registers");
            throw flightException;
        } catch (Exception e) {
            throw new AirportException(ErrorCodeDescription.UNKNOWN_ERROR);
        }
    }

    private List<FlightDTO> convertToFlightDTOList(List<FlightEntity> flightEntityList) {
        List<FlightDTO> flightDTOList = new ArrayList<>();
        flightEntityList.forEach(flight -> flightDTOList.add(flightMapper.toFlightDTO(flight)));
        return flightDTOList;
    }
}
