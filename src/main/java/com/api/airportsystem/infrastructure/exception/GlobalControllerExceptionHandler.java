package com.api.airportsystem.infrastructure.exception;

import com.api.airportsystem.infrastructure.exception.exceptions.AirportException;
import com.api.airportsystem.infrastructure.exception.exceptions.FlightException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {AirportException.class})
    public ResponseEntity<ErrorResponse> airportException(AirportException e) {
        return ResponseEntity
                .status(e.getErrorCodeDescription().getStatus())
                .body(new ErrorResponse(e.getErrorCodeDescription()));
    }

    @ExceptionHandler(value = {FlightException.class})
    public ResponseEntity<ErrorResponse> flightException(FlightException e) {
        return ResponseEntity
                .status(e.getErrorCodeDescription().getStatus())
                .body(new ErrorResponse(e.getErrorCodeDescription()));
    }
}
