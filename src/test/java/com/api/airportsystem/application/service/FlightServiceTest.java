package com.api.airportsystem.application.service;

import com.api.airportsystem.domain.dto.FlightDTO;
import com.api.airportsystem.domain.entity.FlightEntity;
import com.api.airportsystem.domain.enums.Airports;
import com.api.airportsystem.domain.enums.Gates;
import com.api.airportsystem.domain.mapper.FlightMapper;
import com.api.airportsystem.domain.repository.FlightRepository;
import com.api.airportsystem.infrastructure.exception.exceptions.FlightException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static com.api.airportsystem.util.TestUtil.*;
import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
public class FlightServiceTest {
    @Mock
    private FlightRepository flightRepository;

    private FlightService flightService;

    private final FlightMapper flightMapper = Mappers.getMapper(FlightMapper.class);

    @BeforeEach
    void setup() {
        flightService = new FlightService(flightRepository, flightMapper);
    }

    @Test
    @DisplayName("FlightService - Find Flight - Should get one flight by id")
    void shouldGetOneFlightById() {
        Mockito.when(flightRepository.findFlightById(Mockito.anyString())).thenReturn(getFlight(FLIGHT_ID_FIRST,
                Gates.A.name(), Airports.CNF.name(), Airports.MCO.name()));

        FlightDTO response = flightService.getFlightById(FLIGHT_ID_FIRST);

        Mockito.verify(flightRepository, times(1)).findFlightById(FLIGHT_ID_FIRST);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(FLIGHT_ID_FIRST, response.id());
    }

    @Test
    @DisplayName("FlightService - Find Flight - Should throw FlightException when not found ")
    void shouldThrowExceptionWhenFlightNotFound() {
        Mockito.when(flightRepository.findFlightById(Mockito.anyString())).thenReturn(null);

        FlightException exception = Assertions.assertThrows(FlightException.class, () ->
                flightService.getFlightById(FLIGHT_ID_FIRST));

        Assertions.assertEquals("API_ERROR_003", exception.getErrorCodeDescription().getErrorCode());
        Assertions.assertEquals("Could not find flight", exception.getErrorCodeDescription().getErrorMessage());
        Assertions.assertEquals(404, exception.getErrorCodeDescription().getStatus());
    }

    @Test
    @DisplayName("FlightService - Find Flight - Should get all flights")
    void shouldGetAllFlights() {
        List<FlightEntity> createFlightEntityList = getListFlight(getFlight(FLIGHT_ID_FIRST, Gates.A.name(), Airports.CNF.name(),
                Airports.MCO.name()), getFlight(FLIGHT_ID_SECOND, Gates.B.name(), Airports.CNF.name(), Airports.ATL.name()));

        Mockito.when(flightRepository.getAllFlights()).thenReturn(createFlightEntityList);

        List<FlightDTO> response = flightService.getAllFlights();

        Mockito.verify(flightRepository, times(1)).getAllFlights();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(FLIGHT_ID_FIRST, response.get(0).id());
        Assertions.assertEquals(FLIGHT_ID_SECOND, response.get(1).id());
    }

    @Test
    @DisplayName("FlightService - Find Flights - Should throw FlightException when not found ")
    void shouldThrowExceptionWhenFlightsNotFound() {
        Mockito.when(flightRepository.getAllFlights()).thenReturn(null);

        FlightException exception = Assertions.assertThrows(FlightException.class, () -> flightService.getAllFlights());

        Assertions.assertEquals("API_ERROR_009", exception.getErrorCodeDescription().getErrorCode());
        Assertions.assertEquals("Could not find flights registers", exception.getErrorCodeDescription().getErrorMessage());
        Assertions.assertEquals(404, exception.getErrorCodeDescription().getStatus());
    }
}
