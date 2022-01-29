package com.api.airport.application.service;

import com.api.airport.domain.dto.FlightDTO;
import com.api.airport.domain.entity.FlightEntity;
import com.api.airport.domain.mapper.FlightMapper;
import com.api.airport.domain.repository.FlightRepository;
import com.api.airport.infrastructure.exception.AirportException;
import com.api.airport.infrastructure.exception.ErrorCodeDescription;
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
            return flightMapper.toFlightDTO(flightRepository.findFlightById(id));
        } catch (Exception e) {
            log.error("[FlightService] - Not found flight to id: {}", id);
            throw new AirportException(ErrorCodeDescription.NOT_FOUND_FLIGHT);
        }
    }

    public List<FlightDTO> getAllFlights() {
        try {
            return convertToFlightDTOList(flightRepository.getAllFlights());
        } catch (Exception e) {
            log.error("[FlightService] - Not found flights register");
            throw new AirportException(ErrorCodeDescription.NOT_FOUND_FLIGHT);
        }
    }

    private List<FlightDTO> convertToFlightDTOList(List<FlightEntity> flightEntityList) {
        List<FlightDTO> flightDTOList = new ArrayList<>();
        flightEntityList.forEach(flight -> flightDTOList.add(flightMapper.toFlightDTO(flight)));
        return flightDTOList;
    }
}
