package com.api.airport.application.service;

import com.api.airport.domain.repository.FlightRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class FlightServiceTest {
    @Mock
    private FlightRepository flightRepository;

    private FlightService flightService;

}
