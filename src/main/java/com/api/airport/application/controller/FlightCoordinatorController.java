package com.api.airport.application.controller;

import com.api.airport.application.service.FlightCoordinatorService;
import com.api.airport.domain.dto.FlightDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/v1/coordinator/management/flight")
public class FlightCoordinatorController {
    private final FlightCoordinatorService flightCoordinatorService;

    public FlightCoordinatorController(FlightCoordinatorService flightCoordinatorService) {
        this.flightCoordinatorService = flightCoordinatorService;
    }

    @PostMapping
    public ResponseEntity<String> createFlight(@RequestBody FlightDTO flightDTO) {
        flightCoordinatorService.createFlight(flightDTO);
        return ResponseEntity.ok().body("Created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable String id) {
        flightCoordinatorService.deleteFlight(id);
        return ResponseEntity.ok().body("Deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFlight(@PathVariable String id, @RequestBody FlightDTO flightDTO) {
        flightCoordinatorService.updateFlight(id, flightDTO);
        return ResponseEntity.ok().body("Updated");
    }


}
