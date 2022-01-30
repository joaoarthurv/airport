package com.api.airport.infrastructure.exception.exceptions;

import com.api.airport.infrastructure.exception.ErrorCodeDescription;
import lombok.Getter;

@Getter
public class FlightException extends RuntimeException {
    private ErrorCodeDescription errorCodeDescription;

    public FlightException(ErrorCodeDescription errorCodeDescription) {
        this.errorCodeDescription = errorCodeDescription;
    }
}
