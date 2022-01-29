package com.api.airport.infrastructure.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {AirportException.class})
    public ResponseEntity<ErrorResponse> businessException(AirportException e) {
        return ResponseEntity
                .status(e.getErrorCodeDescription().getStatus())
                .body(new ErrorResponse(e.getErrorCodeDescription()));
    }
}
