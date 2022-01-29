package com.api.airport.application.controller;

import com.api.airport.application.service.FlightService;
import com.api.airport.domain.dto.FlightDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/flight")
public class FlightController {
    private final FlightService flightService;


    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDTO> getFlightById(@PathVariable String id){
        return ResponseEntity.ok().body(flightService.getFlightById(id));
    }

    @GetMapping
    public ResponseEntity<List<FlightDTO>> getAllFlights(){
       return ResponseEntity.ok().body(flightService.getAllFlights());
    }
}
